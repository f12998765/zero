package com.x.model;

public class UserPro {
    private Integer proId;

    private Integer userId;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserPro(Integer proId, Integer userId) {
        this.proId = proId;
        this.userId = userId;
    }

    public UserPro() {
    }
}