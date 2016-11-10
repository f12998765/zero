package com.x.inter;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public interface BaseUpMapper<T> extends BaseMapper<T> {

    //查询项目下的所有task
    List<T> selectByUpId(Integer up_id);

    //查询项目下的所有task-分页
    List<T> selectPageByUpId(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize, @Param(value = "up_id") int up_id);

    //查询项目下的所有task-获取总条数
    int selectCountByUpId(@Param(value = "up_id") Integer up_id);
}
