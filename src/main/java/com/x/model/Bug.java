package com.x.model;

import lombok.Data;

import java.util.Date;

@Data
public class Bug {
    private Integer id;

    private Integer userId;

    private Integer taskId;

    private String info;

    private Date begin;

    public Bug() {
    }


    public Bug(Integer userId, Integer taskId, String info, Date begin) {
        this.userId = userId;
        this.taskId = taskId;
        this.info = info;
        this.begin = begin;
    }



    public Bug(Integer id, Integer userId, String info) {
        this.userId = userId;
        this.id = id;
        this.info = info;
    }
}