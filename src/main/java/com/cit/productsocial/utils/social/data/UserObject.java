package com.cit.productsocial.utils.social.data;

import lombok.Data;

import java.sql.Date;

@Data
public class UserObject {
    private String id;
    private String name;
    private String email;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
    private String address;
    private String avatarUrl;
}
