package com.x.model;

public class UserTask {
    private Integer taskId;

    private Integer userId;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserTask() {
    }

    public UserTask(Integer taskId, Integer userId) {

        this.taskId = taskId;
        this.userId = userId;
    }
}