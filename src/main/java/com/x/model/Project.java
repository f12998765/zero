package com.x.model;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private Integer id;

    private Integer userId;

    private String info;

    private Date begin;


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