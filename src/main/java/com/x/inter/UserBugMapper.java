package com.x.inter;

import com.x.model.UserBug;

import java.util.List;

public interface UserBugMapper {
    int insert(UserBug record);

    int insertSelective(UserBug record);

    /*获取参与任务的用户id*/
    List<Integer> selectUserIdByBugId(int id);

    /*获取某用户参与所有任务di*/
    List<Integer> selectBugIdByUserId(int id);

    int delete(UserBug userBug);
}