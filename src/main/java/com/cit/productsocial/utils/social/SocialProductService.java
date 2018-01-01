package com.cit.productsocial.utils.social;

import com.cit.productsocial.utils.social.object.PostDataObject;

import java.util.List;

public interface SocialProductService {
    List<String> post(String feedId, PostDataObject productData);
    void delete(String postId);
    void update(String postId, PostDataObject productData);
    void get(String postId);
}
