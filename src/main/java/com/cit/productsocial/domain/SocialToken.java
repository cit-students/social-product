package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "social_token", schema = "app_db")
@IdClass(SocialTokenPK.class)
@Data
public class SocialToken {
    @Id
    @Column(name = "social_name", nullable = false, length = 20)
    private String socialName;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @Basic
    @Column(name = "update_at", nullable = false)
    private Timestamp updateAt;
    @Basic
    @Column(name = "token", nullable = false, length = -1)
    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialToken)) return false;
        if (!super.equals(o)) return false;

        SocialToken that = (SocialToken) o;

        if (!socialName.equals(that.socialName)) return false;
        if (!user.equals(that.user)) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + socialName.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
