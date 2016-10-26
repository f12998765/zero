package com.x.inter;

import com.x.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserIdAndTaskId(@Param("id")Integer id,@Param("userId")Integer userid);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByUserIdAndTaskId(Task record);

    int updateByPrimaryKey(Task record);

    //查询所有
    List<Task> selectAll();

    //查询所有-分页
    List<Task> selectPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);

    //查询所有-获取总条数
    int getCount();
    
    //查询项目下的所有task
    List<Task> selectByProId(int pro_id);

    //查询项目下的所有task-分页
    List<Task> selectPageByProId(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize, @Param(value = "pro_id") int pro_id);

    //查询项目下的所有task-获取总条数
    int getCountByProId(@Param(value = "pro_id") Integer rpo_id);

    List<Task> selectByUserId(int userid);

    List<Task> selectAllById(List<Integer> ids);
}