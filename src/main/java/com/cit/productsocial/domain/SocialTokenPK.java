package com.cit.productsocial.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class SocialTokenPK implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "social_name", nullable = false, length = 20)
    @Id
    private String socialName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocialTokenPK)) return false;
        if (!super.equals(o)) return false;

        SocialTokenPK that = (SocialTokenPK) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return socialName != null ? socialName.equals(that.socialName) : that.socialName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (socialName != null ? socialName.hashCode() : 0);
        return result;
    }
}
