package com.cit.productsocial.utils.social;

import com.cit.productsocial.utils.social.data.PostDataObject;

import java.util.List;

public interface SocialProductService {
    List<String> post(String pageId, PostDataObject product);
    boolean get(String token);
    void delete(String postId);
    void update(String pageId, PostDataObject product);
}
