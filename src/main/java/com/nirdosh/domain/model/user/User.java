package com.nirdosh.domain.model.user;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    private List<String> roles;

    public User(String userName, String password, List<String> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
