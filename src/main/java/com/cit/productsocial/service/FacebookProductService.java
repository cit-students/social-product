package com.cit.productsocial.service;

import com.cit.productsocial.utils.social.SocialProductService;
import com.cit.productsocial.utils.social.facebook.FacebookClient;
import com.cit.productsocial.utils.social.object.PostDataObject;

import java.util.List;


public class FacebookProductService implements SocialProductService {

    private final FacebookClient fbClient;

    public FacebookProductService(FacebookClient fbClient) {
        this.fbClient = fbClient;
    }

    @Override
    public List<String> post(String id, PostDataObject productData) {
        return fbClient.postProducts(id, productData);
    }

    @Override
    public void delete(String postId) {

    }

    @Override
    public void update(String postId, PostDataObject productData) {

    }

    @Override
    public void get(String postId) {

    }
}
