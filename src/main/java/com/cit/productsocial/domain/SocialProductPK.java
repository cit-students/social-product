package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class SocialProductPK implements Serializable {
    @Column(name = "social_name", nullable = false, length = 20)
    @Id
    private String socialName;
    @Column(name = "social_post_id", nullable = false, length = 64)
    @Id
    private String socialPostId;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialProductPK that = (SocialProductPK) o;

        if (socialName != null ? !socialName.equals(that.socialName) : that.socialName != null) return false;
        if (socialPostId != null ? !socialPostId.equals(that.socialPostId) : that.socialPostId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = socialName != null ? socialName.hashCode() : 0;
        result = 31 * result + (socialPostId != null ? socialPostId.hashCode() : 0);
        return result;
    }
}
