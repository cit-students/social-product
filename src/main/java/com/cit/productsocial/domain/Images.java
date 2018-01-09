package com.cit.productsocial.domain;

import javax.persistence.*;

@Entity
@IdClass(ImagesPK.class)
public class Images {
    private Integer id;
    private String url;
    @Id
    @ManyToOne
    @JoinColumn(name="product_id")
    private Products product;

    private String amazonId;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = false, length = -1)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Basic
    @Column(name = "amazon_id", length = 20)
    public String getAmazonId() {
        return amazonId;
    }

    public void setAmazonId(String amazonId) {
        this.amazonId = amazonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Images images = (Images) o;

        if (id != null ? !id.equals(images.id) : images.id != null) return false;
        if (url != null ? !url.equals(images.url) : images.url != null) return false;
        if (product != null ? !product.equals(images.product) : images.product != null) return false;
        if (amazonId != null ? !amazonId.equals(images.amazonId) : images.amazonId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (amazonId != null ? amazonId.hashCode() : 0);
        return result;
    }
}
