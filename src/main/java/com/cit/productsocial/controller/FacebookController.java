package com.cit.productsocial.controller;

import com.cit.productsocial.service.FacebookProductService;
import com.cit.productsocial.utils.social.data.CommentObject;
import com.cit.productsocial.utils.social.data.PostDataObject;
import com.cit.productsocial.utils.social.facebook.object.FriendTag;
import com.cit.productsocial.utils.social.facebook.object.UserLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cit.productsocial.controller.AbstractController.API_URL;

@RestController
@RequestMapping(API_URL + "/fb")
public class FacebookController {

    @Autowired
    private final FacebookProductService fbService;

    @Autowired
    public FacebookController(FacebookProductService facebookProductService) {
        this.fbService = facebookProductService;
    }

    @GetMapping("/{token}")
    public boolean get(@PathVariable String token) {
        return fbService.get(token);
    }

    @PostMapping()
    public List<String> postProduct(@RequestParam("pageId") String pageId,@RequestBody PostDataObject postDataObject) {
        return fbService.post(pageId, postDataObject);
    }

    @PostMapping("/{postId}")
    public void updateProduct(@PathVariable("postId") String postId) {

    }

    @DeleteMapping("/{postId}")
    public void deleteProduct(@PathVariable("postId") String postId) {
        fbService.delete(postId);
    }

    @GetMapping(path = "comments/{postId}")
    public List<CommentObject> getComments(@PathVariable("postId") String postId) {
        System.out.println(postId);
        return fbService.getComments(postId);
    }

    @GetMapping(path = "friends")
    public List<FriendTag> getFriends() {
        return fbService.getFriends();
    }

    @GetMapping(path = "likes")
    public List<UserLike> getUserLikes() {
        return fbService.getUserLikes();
    }
}