package com.x.model;

import java.util.Date;

public class Bug {
    private Integer id;

    private Integer userId;

    private Integer taskId;

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

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public Bug() {
    }

    public Bug(Integer id, Integer userId, Integer taskId, String info) {
        this.id = id;
        this.userId = userId;
        this.taskId = taskId;
        this.info = info;
    }

    public Bug(Integer userId, Integer taskId, String info, Date begin) {
        this.userId = userId;
        this.taskId = taskId;
        this.info = info;
        this.begin = begin;
    }

    public Bug(Integer id, Integer userId, String info) {
        this.id = id;
        this.userId = userId;
        this.info = info;
    }

    public Bug(Integer id, String info) {
        this.id = id;
        this.info = info;
    }
}