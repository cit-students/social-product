package com.cit.productsocial.utils.social.data;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentObject {
    protected String id;
    protected String message;
    protected String userId;
    protected String userName;
    protected Timestamp createAt;
}
