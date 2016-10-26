package com.x.model;

public class UserBug {
    private Integer bugId;

    private Integer userId;

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserBug() {
    }

    public UserBug(Integer bugId, Integer userId) {

        this.bugId = bugId;
        this.userId = userId;
    }
}