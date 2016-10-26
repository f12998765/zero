package com.x.inter;

import com.x.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询所有
    List<User> selectAll();

    User selectByNameId(String nameId);

    List<User> selectAllById(List<Integer> ids);
}