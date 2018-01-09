package com.cit.productsocial.controller;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductForm {

    private String name;
    private BigDecimal price;
    private String desc;


}
