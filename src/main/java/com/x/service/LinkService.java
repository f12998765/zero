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

    public boolean delLinkPro(UserPro userPro);

    public boolean delLinkTask(UserTask userTask);

    public boolean delLinkBug(UserBug userBug);

    public boolean addLinkPro(UserPro userPro);

    public boolean addLinkTask(UserTask userTask);

    public boolean addLinkBug(UserBug userBug);

}
