package com.cit.productsocial.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ImagesPK implements Serializable {
    private Integer id;

    private Products product;

    @Column(name = "id", nullable = false)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @Id
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagesPK imagesPK = (ImagesPK) o;

        if (id != null ? !id.equals(imagesPK.id) : imagesPK.id != null) return false;
        if (product != null ? !product.equals(imagesPK.product) : imagesPK.product != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
