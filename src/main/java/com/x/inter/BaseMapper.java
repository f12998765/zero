package com.x.inter;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserIdAndId(@Param("userId")Integer userid, @Param("id")Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByUserIdAndId(T t);

    int updateByPrimaryKey(T t);

    //查询所有
    List<T> selectAll();

    //查询所有-分页
    List<T> selectPage(@Param(value = "startPos") Integer startPos, @Param(value = "pageSize") Integer pageSize);

    //查询所有-获取总条数
    int getCount();


    List<T> selectByUserId(Integer userid);

    List<T> selectAllById(List<Integer> ids);
}
