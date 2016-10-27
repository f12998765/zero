package com.x.service.impl;

import com.x.inter.BugMapper;
import com.x.model.Bug;
import com.x.model.User;
import com.x.service.BugService;
import com.x.service.LinkService;
import com.x.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2016/10/20.
 */
@Service
public class BugServiceImpl implements BugService {

    @Resource
    private BugMapper bugMapper;
    @Resource
    private LinkService linkService;

    public Bug getBugById(int id) {
        return this.bugMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Bug> getAllBug() {
        return this.bugMapper.selectAll();
    }

    @Override
    public boolean addBug(Bug bug) {

        List<User> users = this.linkService.getAllUserForBug(bug.getTaskId());
        boolean boo = false;
        for(User u : users){
            if(bug.getUserId() == u.getId()){
                boo = true;
                break;
            }
        }

        if(boo&&this.bugMapper.insert(bug) == 1) return true;
        return false;
    }

    @Override
    public boolean delBug(int userid,int id) {

        if(this.bugMapper.deleteByUserIdAndBugId(userid,id) == 1) return true;
        return false;
    }

    @Override
    public boolean updataBug(Bug bug) {

        if(this.bugMapper.updateByUserIdAndBugId(bug) == 1) return true;
        return false;
    }

    @Override
    public List<Bug> getBugByTaskId(int task_id){
        return this.bugMapper.selectByTaskId(task_id);
    }


    //可变参数，存放每页显示记录的条数
    public List<Bug> getPageByTaskId(int pageNow, int task_id,int pageSize) {

        Page page = null;

        List<Bug> bugs = new ArrayList<Bug>();

        //获取查询数目
        int totalCount = this.bugMapper.getCountByTaskId(task_id);

        page = new Page(pageNow,totalCount);

        page.setPageSize(pageSize);

        bugs = this.bugMapper.selectPageByTaskId(page.getStartPos(), page.getPageSize(), task_id);


        return bugs;
    }

    //可变参数，存放每页显示记录的条数
    public List<Bug> getPage(int pageNow,int pageSize) {

        Page page = null;

        List<Bug> bugs = new ArrayList<Bug>();

        //获取查询数目
        int totalCount = this.bugMapper.getCount();

        page = new Page(pageNow,totalCount);

        page.setPageSize(pageSize);

        bugs = this.bugMapper.selectPage(page.getStartPos(), page.getPageSize());


        return bugs;
    }

    @Override
    public int getCount() {
        return this.bugMapper.getCount();
    }

    @Override
    public int getCountByTaskId(int task_id) {
        return this.bugMapper.getCountByTaskId(task_id);
    }

    @Override
    public List<Bug> getBugByUserId(int id) {
        return this.bugMapper.selectByUserId(id);
    }


}
