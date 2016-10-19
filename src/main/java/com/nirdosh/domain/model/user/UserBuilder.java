package com.nirdosh.domain.model.user;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {
    private String userName;
    private String password;
    private List<String> roles = new ArrayList<>();

    public UserBuilder userName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder role(String role) {
        this.roles.add(role);
        return this;
    }

    public User build() {
        return new User(userName, password, roles);
    }
}