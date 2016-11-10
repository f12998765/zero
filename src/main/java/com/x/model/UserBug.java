package com.x.model;

import lombok.Data;

@Data
public class UserBug {
    private Integer bugId;

    private Integer userId;

    public UserBug() {
    }

    public UserBug(Integer bugId, Integer userId) {

        this.bugId = bugId;
        this.userId = userId;
    }
}