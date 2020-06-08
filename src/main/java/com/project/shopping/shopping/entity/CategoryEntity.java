package com.project.shopping.shopping.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category", schema = "public")
@NamedQueries(
        {
                @NamedQuery(name = "CategoryEntity.categoryByName", query = "select ct from CategoryEntity ct where ct.category = :category"),
                @NamedQuery(name = "CategoryEntity.getAllCategory", query = "select ct from CategoryEntity ct"),
                @NamedQuery(name = "CategoryEntity.CategoryByUuid", query = "select ct from CategoryEntity ct where ct.uuid = :uuid"),
        }
)
public class CategoryEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @Size(max = 64)
    private String uuid;

    @Column(name = "CATEGORY")
    @Size(max = 400)
    @NotNull
    private String category;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }
}
