package com.x.service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public interface BaseUpService<T> extends BaseService<T> {

    public List<T> getByUpId(Integer up_id);

    public List<T> getByUpIdPage(Integer pageNow,Integer up_id,Integer pageSize);

    public Integer getByUpIdCount(Integer up_id);
}
