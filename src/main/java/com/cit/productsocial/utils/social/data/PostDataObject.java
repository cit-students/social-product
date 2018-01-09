package com.cit.productsocial.utils.social.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostDataObject {
    protected String name;
    protected String url;
    protected String description;
    protected List<String> imageUrls;
    protected List<String> linkUrls;
    protected String[] idFriendTags;
    protected BigDecimal price;
    protected PostDataObject productData;
    protected PostDataObject photoData;

    public PostDataObject() {

    }

    public PostDataObject product(String name, String url, BigDecimal price, String description, List<String> imageUrls) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
        this.imageUrls = imageUrls;
        return this;
    }

    public PostDataObject photoData(String name, String url, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
        return this;
    }

}
