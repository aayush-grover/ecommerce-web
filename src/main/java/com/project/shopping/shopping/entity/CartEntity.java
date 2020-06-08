package com.project.shopping.shopping.entity;


import javax.persistence.*;

@Entity
@Table(name = "cart", schema = "public")
@NamedQueries(
        {
                @NamedQuery(name = "CartEntity.userByUserName", query = "select act from CartEntity act where act.username = :username"),
        }
)
public class CartEntity {
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

    @Column(name = "USERNAME")
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", image='" + image + '\'' +
                ", iname='" + iname + '\'' +
                ", specs='" + specs + '\'' +
                ", price='" + price + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
