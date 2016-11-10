package com.x.inter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseLinkMapper<T> {
    int insert(T t);

    int insertSelective(T t);

    /*获取参与的用户id*/
    List<Integer> selectUserId(Integer id);

    /*获取某用户参与所有di*/
    List<Integer> selectByUserId(Integer id);

    int delete(T t);
}
