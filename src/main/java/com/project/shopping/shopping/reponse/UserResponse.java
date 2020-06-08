package com.project.shopping.shopping.reponse;


public class UserResponse {
    private String id = null;
    private String status = null;
    public UserResponse id(String id) {
        this.id = id;
        return this;
    }
    public UserResponse status(String status) {
        this.status = status;
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


    @Override
    public String toString() {
        return "SignupUserResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
