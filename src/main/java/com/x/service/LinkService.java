package com.x.service;

import com.x.model.*;

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

    public boolean delLinkPro(UserPro userPro,int userid);

    public boolean delLinkTask(UserTask userTask,int userid);

    public boolean delLinkBug(UserBug userBug,int userid);

    public boolean addLinkPro(UserPro userPro,int userid);

    public boolean addLinkTask(UserTask userTask,int userid);

    public boolean addLinkBug(UserBug userBug,int userid);

    public List<User> getAllUserForTask(int id);

    public List<User> getAllUserForBug(int id);

}
