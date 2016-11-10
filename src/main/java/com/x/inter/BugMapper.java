package com.x.inter;

import com.x.model.Bug;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugMapper extends BaseMapper<Bug>{


    //查询任务下的所有bug
    List<Bug> selectByTaskId(Integer task_id);

    //查询任务下的所有bug-分页
    List<Bug> selectPageByTaskId(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize, @Param(value = "task_id") int task_id);

    //查询任务下的所有bug-获取总条数
    int getCountByTaskId(@Param(value = "task_id") Integer task_id);

}