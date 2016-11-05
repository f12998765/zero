package com.x.inter;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseMapper<T,ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int deleteByUserIdAndId(@Param("userId")ID userid, @Param("id")ID id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T t);

    int updateByUserIdAndId(T t);

    int updateByPrimaryKey(T t);

    //查询所有
    List<T> selectAll();

    //查询所有-分页
    List<T> selectPage(@Param(value = "startPos") ID startPos, @Param(value = "pageSize") ID pageSize);

    //查询所有-获取总条数
    int getCount();


    List<T> selectByUserId(ID userid);

    List<T> selectAllById(List<ID> ids);
}
