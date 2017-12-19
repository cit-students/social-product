package com.cit.productsocial.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(AbstractController.API_URL + "/users")
public class UserController {
    @PostMapping
    public void updateProfile() {

    }
}
