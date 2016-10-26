package com.x.inter;

import com.x.model.User;
import com.x.model.UserPro;

import java.util.List;

public interface UserProMapper {
    int insert(UserPro record);

    int insertSelective(UserPro record);

    /*获取参与项目的用户id*/
    List<Integer> selectUserIdByProId(int id);

    /*获取某用户参与所有项目di*/
    List<Integer> selectProIdByUserId(int id);


    int delete(UserPro userPro);
}