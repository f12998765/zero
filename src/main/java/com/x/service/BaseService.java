package com.x.service;

import com.x.model.Bug;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseService<T> {

    public T getById(Integer id);

    public boolean add(T t);

    public boolean delete(Integer userid,Integer id);

    public boolean updata(T t);

    public List<T> getAll();

    public List<T> getAllPage(Integer pageNow,Integer pageSize);

    public Integer getAllCount();

    public List<T> getByUserId(Integer id);

}
