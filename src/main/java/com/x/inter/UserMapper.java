package com.x.inter;

import com.x.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{

    User selectByNameId(String nameId);

}