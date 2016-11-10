package com.x.service.impl;

import com.x.inter.TaskMapper;
import com.x.model.Task;
import com.x.model.User;
import com.x.service.LinkService;
import com.x.service.TaskService;
import com.x.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/10/20.
 */
@Service
public class TaskServiceImpl extends BaseUpServiceImpl<Task> implements TaskService {

    @Resource
    private LinkService linkService;

    @Override
    public boolean add(Task task) {

        List<User> users = this.linkService.getAllUserForTask(task.getProId());
        boolean boo = false;
        for(User u : users){
            if(Objects.equals(task.getUserId(), u.getId())){
                boo = true;
                break;
            }
        }
        if(boo&&super.add(task)) return true;
        return false;
    }



}
