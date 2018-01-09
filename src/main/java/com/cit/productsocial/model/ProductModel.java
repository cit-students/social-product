package com.cit.productsocial.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private String desc;
}
