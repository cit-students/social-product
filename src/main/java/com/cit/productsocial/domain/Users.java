package com.cit.productsocial.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String socialId;
    private String socialName;


    private Collection<SocialToken> socialTokens;



    private Collection<Products> products;


    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 256)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "social_id", nullable = true, length = 32)
    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    @Basic
    @Column(name = "social_name", nullable = true, length = 20)
    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(users.phoneNumber) : users.phoneNumber != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (socialId != null ? !socialId.equals(users.socialId) : users.socialId != null) return false;
        if (socialName != null ? !socialName.equals(users.socialName) : users.socialName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (socialId != null ? socialId.hashCode() : 0);
        result = 31 * result + (socialName != null ? socialName.hashCode() : 0);
        return result;
    }
    @OneToMany(mappedBy = "users")
    public Collection<Products> getProducts() {
        return products;
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }
    @OneToMany(mappedBy = "user")
    public Collection<SocialToken> getSocialTokens() {
        return socialTokens;
    }

    public void setSocialTokens(Collection<SocialToken> socialTokens) {
        this.socialTokens = socialTokens;
    }

}
