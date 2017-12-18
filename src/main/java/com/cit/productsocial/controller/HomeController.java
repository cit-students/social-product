package com.cit.productsocial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(com.cit.productsocial.controller.AbstractController.API_URL)
public class HomeController extends AbstractController {

    @GetMapping
    public String home() {
        return "Hello World";
    }
}
