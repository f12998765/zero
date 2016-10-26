package com.x.inter;

import com.x.model.Bug;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserIdAndBugId(@Param("id")Integer id,@Param("userId")Integer userid);

    int insert(Bug record);

    int insertSelective(Bug record);

    Bug selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bug record);

    int updateByUserIdAndBugId(Bug record);

    int updateByPrimaryKey(Bug record);

    //查询所有
    List<Bug> selectAll();

    //查询所有-分页
    List<Bug> selectPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);

    //查询所有-获取总条数
    int getCount();

    //查询任务下的所有bug
    List<Bug> selectByTaskId(int task_id);

    //查询任务下的所有bug-分页
    List<Bug> selectPageByTaskId(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize, @Param(value = "task_id") int task_id);

    //查询任务下的所有bug-获取总条数
    int getCountByTaskId(@Param(value = "task_id") Integer task_id);


    List<Bug> selectByUserId(int userid);

    List<Bug> selectAllById(List<Integer> ids);

}