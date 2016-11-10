package com.x.model;

import lombok.Data;

@Data
public class UserTask {
    private Integer taskId;

    private Integer userId;

    public UserTask() {
    }

    public UserTask(Integer taskId, Integer userId) {

        this.taskId = taskId;
        this.userId = userId;
    }
}