package com.x.service;

import com.x.model.Task;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public interface TaskService {
    public Task getTaskById(int id);

    public List<Task> getAllTask();

    public boolean addTask(Task task);

    public boolean delTask(int userid,int id);

    public boolean updataTask(Task task);

    public List<Task> getTaskByProId(int pro_id);

    public List<Task> getPageByProId(int pageNow, int pro_id,int pageSize);

    public List<Task> getPage(int pageNow,int pageSize);

    public int getCount();

    public int getCountByProId(int pro_id);


    public List<Task> getTaskByUserId(int id);

}
