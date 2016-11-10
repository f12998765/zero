package com.x.service;

import com.x.model.Bug;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseService<T> {

    public T getById(Integer id);

    public List<T> getAll();

    public boolean add(T t);

    public boolean delete(Integer userid,Integer id);

    public boolean updata(T t);

    public List<T> getByUpId(Integer up_id);

    public List<T> getByUpIdPage(Integer pageNow,Integer up_id,Integer pageSize);

    public List<T> getAllPage(Integer pageNow,Integer pageSize);

    public Integer getAllCount();

    public Integer getByUpIdCount(Integer up_id);

    public List<T> getByUserId(Integer id);

}
