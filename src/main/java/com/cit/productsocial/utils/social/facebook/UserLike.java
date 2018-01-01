package com.cit.productsocial.utils.social.facebook;

import lombok.Data;

@Data
public class UserLike {
    private String id;
    private String name;
    private final static String FACE_BOOK_URL = "https://www.facebook.com/";

    public String getLink() {
        return FACE_BOOK_URL + id;
    }
}
