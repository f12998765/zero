package com.x.model;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    private Integer id;

    private Integer userId;

    private Integer proId;

    private String info;

    private Date begin;


    public Task() {
    }

    public Task(Integer userId, Integer proId, String info, Date begin) {

        this.userId = userId;
        this.proId = proId;
        this.info = info;
        this.begin = begin;
    }


    public Task(Integer id,Integer userId, String info) {
        this.userId = userId;
        this.id = id;
        this.info = info;
    }
}