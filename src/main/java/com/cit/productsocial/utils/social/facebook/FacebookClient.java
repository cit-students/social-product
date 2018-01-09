package com.cit.productsocial.utils.social.facebook;

import com.cit.productsocial.utils.social.SocialProductInterface;
import com.cit.productsocial.utils.social.facebook.object.FriendTag;
import com.cit.productsocial.utils.social.facebook.object.UserLike;
import com.cit.productsocial.utils.social.data.CommentObject;
import com.cit.productsocial.utils.social.data.PostDataObject;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.codec.CharEncoding.UTF_8;

@Data
public class FacebookClient implements SocialProductInterface {

    private String accessToken;
    private final HttpClient client;

    private static final String FB_GRAPH_API = "https://graph.facebook.com/v2.11/";
    private static final String FB_DEFAULT_PAGE_ID = "me";

    public FacebookClient() {
        client = HttpClientBuilder.create().build();
    }

    public FacebookClient(String accessToken) {
        this.accessToken = accessToken;
        client = HttpClientBuilder.create().build();
    }


    @Override
    public boolean isTokenValid() {
        HttpPost request = new HttpPost(FB_GRAPH_API + "me?access_token=" + accessToken);
        try {
            HttpResponse response = client.execute(request);
            JSONObject result = new JSONObject(EntityUtils.toString(response.getEntity()));
            if (result.has("error")) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String postPhoto(PostDataObject photoData) {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is invalid or has been expired");
        HttpPost postRequest = new HttpPost(FB_GRAPH_API + "me/photos");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("url", photoData.getUrl()));
        params.add(new BasicNameValuePair("access_token", accessToken));
        params.add(new BasicNameValuePair("published", "false"));
        try {
            postRequest.setEntity(new UrlEncodedFormEntity(params, UTF_8));
            return getValue(client.execute(postRequest), "id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Note: final element is id of main post
     * other elements are id of photo
     *
     * */
    @Override
    public List<String> postProducts(String pageId, PostDataObject productData) {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is invalid or has been expired");
        if (pageId.isEmpty()) {
            pageId = FB_DEFAULT_PAGE_ID;
        }
        HttpPost postRequest = new HttpPost(FB_GRAPH_API + pageId + "/feed");
        List<NameValuePair> params = new ArrayList<>();
        String message = sellingTemplate(productData);
        params.add(new BasicNameValuePair("message", message));
        params.add(new BasicNameValuePair("access_token", accessToken));
        List<String> imageUrls = productData.getImageUrls();
        List<String> listIds = new ArrayList<>();
        /* Upload multi photos */
        if (imageUrls.size() > 0) {
            int i = 0;
            for (String imageUrl : imageUrls) {
                String id = postPhoto(new PostDataObject()
                                .photoData("", imageUrl, "", productData.getPrice()));
                listIds.add(id);
                params.add(new BasicNameValuePair("attached_media" + "["+ (i++) +"]",
                        "{" + "media_fbid" + ":" + id + "}"));
            }
        }
        /* Tag friends */
        if (productData.getIdFriendTags() != null) {
            params.add(new BasicNameValuePair("tags", productData.getIdFriendTags()[0]));
        }
        try {
            postRequest.setEntity(new UrlEncodedFormEntity(params, UTF_8));
            listIds.add(0, getValue(client.execute(postRequest), "id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIds;
    }

    @Override
    public void deleteProducts(String postId) {
        HttpDelete deleteRequest = new HttpDelete(FB_GRAPH_API + postId);
        try {
            System.out.println(EntityUtils.toString(client.execute(deleteRequest).getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update post
     * The fields an app can update are: message, tags, privacy
     *
     * */
    @Override
    public void updateProduct(String postId, PostDataObject productData) {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is not invalid or has been expired");
        HttpPost postRequest = new HttpPost(FB_GRAPH_API + postId);
        List<NameValuePair> params = new ArrayList<>();
        if (productData.getDescription() != null) {
            params.add(new BasicNameValuePair("message", sellingTemplate(productData)));
        }
        if (productData.getIdFriendTags().length > 0) {
            params.add(new BasicNameValuePair("tags", productData.getIdFriendTags()[0]));
        }
        try {
            postRequest.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(postRequest);
            String error = getValue(response, "error");
            if (error.length() > 0) {
                throw new IllegalArgumentException("ERROR: " + error);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<CommentObject> getListComments(String postId) {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is not invalid or has been expired");
        HttpGet getRequest = new HttpGet(FB_GRAPH_API + postId + "/comments" + "?access_token=" + accessToken);
        try {
            HttpResponse response = client.execute(getRequest);
            JSONObject result = new JSONObject(EntityUtils.toString(response.getEntity()));
            JSONArray data = result.getJSONArray("data");
            int size = data.length();
            List<CommentObject> commentList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                JSONObject object = data.getJSONObject(i);
                CommentObject comment = new CommentObject();
                comment.setCreateAt(getDateTime(object.getString("created_time")));
                comment.setMessage(object.getString("message"));
                comment.setId(object.getString("id"));
                JSONObject nodeObject = object.getJSONObject("from");
                comment.setUserName(nodeObject.getString("name"));
                comment.setUserId(nodeObject.getString("id"));
                commentList.add(comment);
            }
            return commentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Return a list friends cant be tagged into the post
     * of current user
     * */
    public List<FriendTag> getListFriendsTag() {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is not invalid or has been expired");
        HttpGet getRequest = new HttpGet(FB_GRAPH_API + "me" + "/taggable_friends" + "?access_token=" + accessToken);
        try {
            HttpResponse response = client.execute(getRequest);
            JSONObject result = new JSONObject(EntityUtils.toString(response.getEntity()));
            if (result.has("error")) {
                throw new RuntimeException("ERROR:" + result.getJSONObject("error"));
            }
            JSONArray data = result.getJSONArray("data");
            int size = data.length();
            List<FriendTag> friendTags = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                JSONObject object = data.getJSONObject(i);
                FriendTag friendTag = new FriendTag(object.getString("id"), object.getString("name"), "");
                String avatarUrl = object.getJSONObject("picture")
                        .getJSONObject("data")
                        .getString("url");
                friendTag.setAvatarSmallUrl(avatarUrl);
                friendTags.add(friendTag);
            }
            return friendTags;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Return a list of page or Group
     *
     * */
    public List<UserLike> getLikes() {
        if (!isTokenValid()) throw new IllegalArgumentException("Access token is not invalid or has been expired");
        HttpGet getRequest = new HttpGet(FB_GRAPH_API + "me/" + "likes");
        try {
            HttpResponse response = client.execute(getRequest);
            JSONObject result = new JSONObject(EntityUtils.toString(response.getEntity()));
            if (result.has("error")) throw new RuntimeException(result.getJSONObject("error").toString());
            JSONArray data = result.getJSONArray("data");
            List<UserLike> userLikes = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                JSONObject object = data.getJSONObject(i);
                UserLike userLike = new UserLike();
                userLike.setId(object.getString("id"));
                userLike.setName(object.getString("name"));
                userLikes.add(userLike);
            }
            return userLikes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Simple template message for post
     *
     * */
    private String sellingTemplate(PostDataObject data) {
        StringBuilder message = new StringBuilder();
        String name = data.getName();
        String description = data.getDescription();
        BigDecimal price = data.getPrice();
        if (!name.isEmpty()) {
            message.append("\uD83D\uDCE6" + " Sản phẩm: ").append(name).append("\n");
        }
        if (!description.isEmpty()) {
            message.append("\uD83D\uDC4D" + " Mô tả: ").append(description);
        }
        if (price != null) {
            message.append("\n----------------------------------------------------\n");
            message.append("\uD83D\uDCB5" + " Giá:").append(price).append("₫\n");
        }
        if (data.getLinkUrls() != null) {
            for (String link : data.getLinkUrls()) {
                message.append("Link: ").append(link).append("\n");
            }
        }
        return message.toString();
    }

    private String getValue(HttpResponse response, String key) throws IOException {
        JSONObject result = new JSONObject(EntityUtils.toString(response.getEntity()));
        return result.has(key) ? result.get(key).toString() : "";
    }

    private Timestamp getDateTime(String dateTime) {
        try {
            DateTime time = new DateTime();
            return new Timestamp(12345678);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
