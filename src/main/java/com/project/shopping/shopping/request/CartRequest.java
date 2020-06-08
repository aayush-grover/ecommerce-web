package com.project.shopping.shopping.request;

import java.io.Serializable;

public class CartRequest implements Serializable {
    private String image;

    private String iname;

    private String specs;

    private String price;

    private String username;

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
        return "CartRequest{" +
                "image='" + image + '\'' +
                ", iname='" + iname + '\'' +
                ", specs='" + specs + '\'' +
                ", price='" + price + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
