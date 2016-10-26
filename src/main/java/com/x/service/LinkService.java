package com.x.service;

import com.x.model.Bug;
import com.x.model.Project;
import com.x.model.Task;
import com.x.model.User;

import java.util.List;

/**
 * Created by xi on 16-10-24.
 */
public interface LinkService {

    public List<User> getUserByJoinPro(int id);

    public List<User> getUserByJoinTask(int id);

    public List<User> getUserByJoinBug(int id);

    public List<Project> getProByJoinUser(int id);

    public List<Task> getTaskByJoinUser(int id);

    public List<Bug> getBugByJoinUser(int id);

    public boolean delLinkPro(int userid,int proid);

    public boolean delLinkTask(int userid,int taskid);

    public boolean delLinkBug(int userid,int bugid);

}
