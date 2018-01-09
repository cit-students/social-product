package com.cit.productsocial.domain;

import com.cit.productsocial.model.ProductModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Products {
    private Long id;
    private String name;
    private BigDecimal price;
    private String desc;

    private Collection<Images> images;


    private Collection<Comments> comments;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private Collection<SocialProduct> socialProducts;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductModel toModel() {
        ProductModel st = new ProductModel();
        st.setId(id);
        st.setName(name);
        st.setDesc(desc);
        //st.setSubjects(getSubjects().stream().map(Subjects::toSubjectsForm).collect(Collectors.toSet()));
        return st;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "desc", nullable = true, length = -1)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != null ? !id.equals(products.id) : products.id != null) return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (desc != null ? !desc.equals(products.desc) : products.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "product")
    public Collection<Images> getImages() {
        return images;
    }

    public void setImages(Collection<Images> images) {
        this.images = images;
    }


    @OneToMany(mappedBy = "product")
    public Collection<Comments> getComments() {
        return comments;
    }

    public void setComments(Collection<Comments> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "product")
    public Collection<SocialProduct> getSocialProducts() {
        return socialProducts;
    }

    public void setSocialProducts(Collection<SocialProduct> socialProducts) {
        this.socialProducts = socialProducts;
    }
}
