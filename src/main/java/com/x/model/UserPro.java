package com.x.model;

import lombok.Data;

@Data
public class UserPro {
    private Integer proId;

    private Integer userId;

    public UserPro(Integer proId, Integer userId) {
        this.proId = proId;
        this.userId = userId;
    }

    public UserPro() {
    }
}