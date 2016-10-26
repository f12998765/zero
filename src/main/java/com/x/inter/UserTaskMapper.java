package com.x.inter;

import com.x.model.UserTask;

import java.util.List;

public interface UserTaskMapper {
    int insert(UserTask record);

    int insertSelective(UserTask record);

    /*获取参与任务的用户id*/
    List<Integer> selectUserIdByTaskId(int id);

    /*获取某用户参与所有任务di*/
    List<Integer> selectTaskIdByUserId(int id);


    int delete(UserTask userTask);
}