package com.cit.productsocial.utils.social.object;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostDataObject {
    protected String caption;
    protected String name;
    protected String url;
    protected String description;
    protected List<String> imageUrls;
    protected List<String> linkUrls;
    protected String[] idFriendTags;
    protected BigDecimal price;
    protected String saleInfo;
    protected PostDataObject productData;
    protected PostDataObject photoData;

    public PostDataObject product(String caption, String name, String url, BigDecimal price, String description, String saleInfo, List<String> imageUrls) {
        this.caption = caption;
        this.name = name;
        this.description = description;
        this.url = url;
        this.price = price;
        this.saleInfo = saleInfo;
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
