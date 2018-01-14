package com.cit.productsocial.utils.social;

import com.cit.productsocial.utils.social.data.PostDataObject;
import com.cit.productsocial.utils.social.data.UserObject;

import java.util.List;

public interface SocialProductInterface {
    boolean isTokenValid();
    UserObject getInfoFromToken();
    String postPhoto(PostDataObject photoData);
    List postProducts(String pageId, PostDataObject productData);
    void deleteProducts(String postId);
    void updateProduct(String postId, PostDataObject productData);
    List getListComments(String postId);
}
