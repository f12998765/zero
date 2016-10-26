package com.x.service.impl;

import com.x.inter.ProjectMapper;
import com.x.inter.UserMapper;
import com.x.inter.UserProMapper;
import com.x.model.Project;
import com.x.model.User;
import com.x.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xi on 16-10-23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;



    public User getUserById(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByNameId(String nameId) {
        return this.userMapper.selectByNameId(nameId);
    }

    public List<User> getAllUser() {
        List<User> users = this.userMapper.selectAll();

        for(User u :users){
            u.setPassword("********");
        }

        return users;
    }

    public boolean addUser(User user) {
        int num = this.userMapper.insert(user);
        if(num == 1) return true;
        return false;
    }

    public boolean delUser(int id) {
        int num = this.userMapper.deleteByPrimaryKey(id);
        if(num == 1) return true;
        return false;
    }

    public boolean updataUser(User user) {
        int num = this.userMapper.updateByPrimaryKeySelective(user);
        if(num == 1) return true;
        return false;
    }

}
