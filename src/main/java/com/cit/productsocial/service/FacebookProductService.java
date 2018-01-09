package com.cit.productsocial.service;

import com.cit.productsocial.utils.social.SocialProductService;
import com.cit.productsocial.utils.social.data.CommentObject;
import com.cit.productsocial.utils.social.facebook.FacebookClient;
import com.cit.productsocial.utils.social.data.PostDataObject;
import com.cit.productsocial.utils.social.facebook.object.FriendTag;
import com.cit.productsocial.utils.social.facebook.object.UserLike;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacebookProductService implements SocialProductService {

    private FacebookClient fbClient;

    public FacebookProductService() {
        this.fbClient = new FacebookClient();
    }

    @Override
    public List<String> post(String pageId, PostDataObject product) {
       return fbClient.postProducts(pageId, product);
    }

    @Override()
    public boolean get(String token) {
        fbClient.setAccessToken(token);
        return fbClient.isTokenValid();
    }

    @Override
    public void delete(String postId) {
        fbClient.deleteProducts(postId);
    }

    @Override
    public void update(String pageId, PostDataObject product) {
        fbClient.updateProduct(pageId, product);
    }

    public List<FriendTag> getFriends() {
        return fbClient.getListFriendsTag();
    }

    public List<CommentObject> getComments(String postId) {
        return fbClient.getListComments(postId);
    }

    public List<UserLike> getUserLikes() {
        return fbClient.getLikes();
    }
}
