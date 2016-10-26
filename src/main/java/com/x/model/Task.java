package com.x.model;

import java.util.Date;

public class Task {
    private Integer id;

    private Integer userId;

    private Integer proId;

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

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
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

    public Task() {
    }

    public Task(Integer id, Integer userId, Integer proId, String info) {
        this.id = id;
        this.userId = userId;
        this.proId = proId;
        this.info = info;
    }

    public Task(Integer userId, Integer proId, String info, Date begin) {

        this.userId = userId;
        this.proId = proId;
        this.info = info;
        this.begin = begin;
    }

    public Task(Integer id, Integer userId, String info) {
        this.id = id;
        this.userId = userId;
        this.info = info;
    }

    public Task(Integer id, String info) {

        this.id = id;
        this.info = info;
    }
}