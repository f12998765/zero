package com.x.service.impl;

import com.x.model.Bug;
import com.x.model.Task;
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
public class BugServiceImpl extends BaseUpServiceImpl<Bug>  implements BugService {

    @Resource
    private LinkService linkService;


    @Override
    public boolean add(Bug bug) {
        List<User> users = this.linkService.getAllUserForBug(bug.getTaskId());
        boolean boo = false;
        for(User u : users){
            if(Objects.equals(bug.getUserId(), u.getId())){
                boo = true;
                break;
            }
        }
        if(boo&&super.add(bug)) return true;
        return false;
    }


}
