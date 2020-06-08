package com.project.shopping.shopping.reponse;

public class LoginResponse {
    private String id = null;
    private String status = null;
    private String accessToken = null;
    private String username= null;
    public LoginResponse id(String id) {
        this.id = id;
        return this;
    }
    public LoginResponse status(String status) {
        this.status = status;
        return this;
    }
    public LoginResponse accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
    public LoginResponse username(String username) {
        this.username = username;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
