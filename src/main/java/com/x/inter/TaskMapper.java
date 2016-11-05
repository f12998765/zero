package com.x.inter;

import com.x.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper extends BaseMapper<Task>{
    
    //查询项目下的所有task
    List<Task> selectByProId(int pro_id);

    //查询项目下的所有task-分页
    List<Task> selectPageByProId(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize, @Param(value = "pro_id") int pro_id);

    //查询项目下的所有task-获取总条数
    int getCountByProId(@Param(value = "pro_id") Integer rpo_id);

}