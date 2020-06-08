package com.project.shopping.shopping.reponse;

public class CategoryResponse {
    private String id = null;
    private String status = null;
    private String category = null;
    public CategoryResponse id(String id) {
        this.id = id;
        return this;
    }
    public CategoryResponse status(String status) {
        this.status = status;
        return this;
    }
    public CategoryResponse category(String category) {
        this.category = category;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
