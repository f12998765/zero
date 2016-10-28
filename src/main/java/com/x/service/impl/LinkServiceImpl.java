package com.x.service.impl;

import com.x.inter.*;
import com.x.model.*;
import com.x.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xi on 16-10-24.
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserProMapper userProMapper;
    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private UserTaskMapper userTaskMapper;
    @Resource
    private TaskMapper taskMapper;

    @Resource
    private UserBugMapper userBugMapper;
    @Resource
    private BugMapper bugMapper;

    @Override
    public List<User> getUserByJoinPro(int id) {
        List<Integer> list = this.userProMapper.selectUserIdByProId(id);
        if(list.size()==0)return null;
        List<User> list1= this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<User> getUserByJoinTask(int id) {
        List<Integer> list = this.userTaskMapper.selectUserIdByTaskId(id);
        if(list.size()==0)return null;
        List<User> list1 = this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<User> getUserByJoinBug(int id) {
        List<Integer> list = this.userBugMapper.selectUserIdByBugId(id);
        if(list.size()==0)return null;
        List<User> list1 = this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Project> getProByJoinUser(int id) {
        List<Integer> list = this.userProMapper.selectProIdByUserId(id);
        if(list.size()==0)return null;
        List<Project> list1 = this.projectMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Task> getTaskByJoinUser(int id) {
        List<Integer> list = this.userTaskMapper.selectUserIdByTaskId(id);
        if(list.size()==0)return null;
        List<Task> list1 = this.taskMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Bug> getBugByJoinUser(int id) {
        List<Integer> list = this.userBugMapper.selectBugIdByUserId(id);
        if(list.size()==0)return null;
        List<Bug> list1 = this.bugMapper.selectAllById(list);
        return list1;
    }

    @Override
    public boolean delLinkPro(UserPro userPro,int userid) {
        Project project = this.projectMapper.selectByPrimaryKey(userPro.getProId());
        if(project.getUserId()==userid&&this.userProMapper.delete(userPro) == 1) return true;
        return false;
    }

    @Override
    public boolean delLinkTask(UserTask userTask,int userid) {
        Task task = this.taskMapper.selectByPrimaryKey(userTask.getTaskId());
        if(task.getUserId()==userid&&this.userTaskMapper.delete(userTask) == 1) return true;
        return false;
    }

    @Override
    public boolean delLinkBug(UserBug userBug,int userid) {
        Bug bug = this.bugMapper.selectByPrimaryKey(userBug.getBugId());
        if(bug.getUserId()==userid&&this.userBugMapper.delete(userBug) == 1) return true;
        return false;
    }

    @Override
    public boolean addLinkPro(UserPro userPro,int userid) {
        Project project = this.projectMapper.selectByPrimaryKey(userPro.getProId());
        if(project.getUserId() == userid&&this.userProMapper.insert(userPro) == 1)
            return true;
        return false;
    }

    @Override
    public boolean addLinkTask(UserTask userTask,int userid) {
        boolean boo = false;
        Task task = this.taskMapper.selectByPrimaryKey(userTask.getTaskId());
        if(task.getUserId() == userid){
            List<User> users = this.getAllUserForTask(userTask.getTaskId());
            for(User u : users){
                if(u.getId().equals(userTask.getUserId())){
                    boo = true;
                    break;
                }
            }
        }
        if(boo&&this.userTaskMapper.insert(userTask) == 1) return true;
        return false;
    }

    @Override
    public boolean addLinkBug(UserBug userBug,int userid) {
        boolean boo = false;
        Bug bug = this.bugMapper.selectByPrimaryKey(userBug.getBugId());
        if(bug.getUserId() == userid){
            List<User> users = this.getAllUserForBug(userBug.getBugId());
            for(User u : users){
                if(u.getId().equals(userBug.getUserId())){
                    boo = true;
                    break;
                }
            }
        }
        if(boo&&this.userBugMapper.insert(userBug) == 1) return true;
        return false;
    }

    @Override
    public List<User> getAllUserForBug(int id) {
        Task t = this.taskMapper.selectByPrimaryKey(id);
        return this.getAllUserForTask(t.getProId());
    }

    @Override
    public List<User> getAllUserForTask(int id) {
        List<User> users = this.getUserByJoinPro(id);
        Project p = this.projectMapper.selectByPrimaryKey(id);
        User u = this.userMapper.selectByPrimaryKey(p.getUserId());
        users.add(u);
        return users;
    }


}
