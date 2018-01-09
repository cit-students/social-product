package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "social_product", schema = "app_db")
@IdClass(SocialProductPK.class)
@Data
public class SocialProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    @Id
    @Column(name = "social_name", nullable = false, length = 20)
    private String socialName;
    @Id
    @Column(name = "social_post_id", nullable = false, length = 64)
    private String socialPostId;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Timestamp createAt;
}
