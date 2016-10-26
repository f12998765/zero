package com.x.service;

import com.x.model.Project;
import com.x.model.User;

import java.util.List;

/**
 * Created by xi on 16-10-23.
 */
public interface UserService {

    public User getUserById(int id);

    public User getUserByNameId(String nameId);

    public List<User> getAllUser();

    public boolean addUser(User user);

    public boolean delUser(int id);

    public boolean updataUser(User user);


}
