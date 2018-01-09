package com.cit.productsocial.utils.social.facebook.object;

import lombok.Data;

@Data
public class UserLike {
    private final static String FACE_BOOK_URL = "https://www.facebook.com/";
    private String id;
    private String name;

    public UserLike() {

    }

    public UserLike(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getLinkToPage() {
        return FACE_BOOK_URL + id;
    }
}
