package com.project.shopping.shopping.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "items", schema = "public")
@NamedQueries(
        {
//                @NamedQuery(name = "itemsByCategory", query = "select it from ItemEntity it where it.category = :category"),
                @NamedQuery(name = "ItemEntity.allItemByCategory", query = "select it from ItemEntity it where it.categoryuuid = :categoryuuid"),
        }
)
public class ItemEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "INAME")
    private String iname;

    @Column(name = "SPECS")
    private String specs;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "CATEGORYUUID")
    private String categoryuuid;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    public String getCategoryuuid() {
        return categoryuuid;
    }

    public void setCategoryuuid(String categoryuuid) {
        this.categoryuuid = categoryuuid;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", image='" + image + '\'' +
                ", iname='" + iname + '\'' +
                ", specs='" + specs + '\'' +
                ", price='" + price + '\'' +
                ", categoryuuid='" + categoryuuid + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
