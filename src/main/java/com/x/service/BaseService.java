package com.x.service;

import com.x.model.Bug;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public interface BaseService<T,ID extends Serializable> {

    public T getById(ID id);

    public List<T> getAll();

    public boolean add(T t);

    public boolean delete(ID userid,ID id);

    public boolean updata(T t);

    public List<T> getByUpId(ID up_id);

    public List<T> getByUpIdPage(ID pageNow,ID up_id,ID pageSize);

    public List<T> getAllPage(ID pageNow,ID pageSize);

    public ID getAllCount();

    public ID getByUpIdCount(ID up_id);

    public List<T> getByUserId(ID id);

}
