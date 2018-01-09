package com.cit.productsocial.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductForm {

    private String name;
    private BigDecimal price;
    private String desc;


    private List<String> images;
}
