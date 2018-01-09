package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@IdClass(CommentsPK.class)
@Data
public class Comments {
    @Id
    @Column(name = "message_id", nullable = false, length = 64)
    private String messageId;
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
    private String content;
    @Basic
    @Column(name = "comment_by_name", nullable = true, length = 32)
    private String commentByName;
    @Basic
    @Column(name = "comment_by_id", nullable = true, length = 64)
    private String commentById;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Timestamp createAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (messageId != null ? !messageId.equals(comments.messageId) : comments.messageId != null) return false;

        if (socialName != null ? !socialName.equals(comments.socialName) : comments.socialName != null) return false;
        if (socialPostId != null ? !socialPostId.equals(comments.socialPostId) : comments.socialPostId != null)
            return false;
        if (commentByName != null ? !commentByName.equals(comments.commentByName) : comments.commentByName != null)
            return false;
        if (commentById != null ? !commentById.equals(comments.commentById) : comments.commentById != null)
            return false;
        if (createAt != null ? !createAt.equals(comments.createAt) : comments.createAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId != null ? messageId.hashCode() : 0;

        result = 31 * result + (socialName != null ? socialName.hashCode() : 0);
        result = 31 * result + (socialPostId != null ? socialPostId.hashCode() : 0);
        result = 31 * result + (commentByName != null ? commentByName.hashCode() : 0);
        result = 31 * result + (commentById != null ? commentById.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        return result;
    }
}
