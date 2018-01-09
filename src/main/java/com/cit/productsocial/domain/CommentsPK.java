package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class CommentsPK implements Serializable {
    @Id
    @Column(name = "message_id", nullable = false, length = 64)
    private String messageId;
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
        if (!(o instanceof CommentsPK)) return false;

        CommentsPK that = (CommentsPK) o;

        if (!messageId.equals(that.messageId)) return false;
        if (!socialName.equals(that.socialName)) return false;
        if (!socialPostId.equals(that.socialPostId)) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = messageId.hashCode();
        result = 31 * result + socialName.hashCode();
        result = 31 * result + socialPostId.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
