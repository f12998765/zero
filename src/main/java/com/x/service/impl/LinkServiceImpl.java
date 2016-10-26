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
        List<User> list1= this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<User> getUserByJoinTask(int id) {
        List<Integer> list = this.userTaskMapper.selectUserIdByTaskId(id);
        List<User> list1 = this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<User> getUserByJoinBug(int id) {
        List<Integer> list = this.userBugMapper.selectUserIdByBugId(id);
        List<User> list1 = this.userMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Project> getProByJoinUser(int id) {
        List<Integer> list = this.userProMapper.selectProIdByUserId(id);
        List<Project> list1 = this.projectMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Task> getTaskByJoinUser(int id) {
        List<Integer> list = this.userTaskMapper.selectUserIdByTaskId(id);
        List<Task> list1 = this.taskMapper.selectAllById(list);
        return list1;
    }

    @Override
    public List<Bug> getBugByJoinUser(int id) {
        List<Integer> list = this.userBugMapper.selectBugIdByUserId(id);
        List<Bug> list1 = this.bugMapper.selectAllById(list);
        return list1;
    }

    @Override
    public boolean delLinkPro(int userid, int proid) {
        int num = this.userProMapper.delete(new UserPro(userid,proid));
        if(num == 1) return true;
        return false;
    }

    @Override
    public boolean delLinkTask(int userid, int taskid) {
        int num = this.userTaskMapper.delete(new UserTask(userid,taskid));
        if(num == 1) return true;
        return false;
    }

    @Override
    public boolean delLinkBug(int userid, int bugid) {
        int num = this.userBugMapper.delete(new UserBug(userid,bugid));
        if(num == 1) return true;
        return false;
    }
}
