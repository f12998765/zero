package com.x.model;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String userid;

    private String password;

    private String username;

    public User(String userid, String password, String username) {
        this.userid = userid;
        this.password = password;
        this.username = username;
    }

    public User() {
    }
}