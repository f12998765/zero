package com.x.service;

import com.x.model.Bug;
import com.x.util.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/20.
 */
public interface BugService {
    public Bug getBugById(int id);

    public List<Bug> getAllBug();

    public boolean addBug(Bug bug);

    public boolean delBug(int userid,int id);

    public boolean updataBug(Bug bug);

    public List<Bug> getBugByTaskId(int task_id);

    public List<Bug> getPageByTaskId(int pageNow, int task_id,int pageSize);

    public List<Bug> getPage(int pageNow,int pageSize);

    public int getCount();

    public int getCountByTaskId(int task_id);

    public List<Bug> getBugByUserId(int id);

}
