package com.x.model;

import java.util.Date;

public class Project {
    private Integer id;

    private Integer userId;

    private String info;

    private Date begin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Project(Integer userId, String info, Date begin) {
        this.userId = userId;
        this.info = info;
        this.begin = begin;
    }

    public Project(Integer id, Integer userId, String info) {
        this.id = id;
        this.userId = userId;
        this.info = info;
    }

    public Project(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Project() {

    }
}