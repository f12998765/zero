package com.x.service.impl;

import com.x.inter.BaseMapper;
import com.x.service.BaseService;
import com.x.util.Page;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Resource
    private BaseMapper<T> baseMapper;

    @Override
    public T getById(Integer id) {
        return this.baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean add(T t) {
        if(this.baseMapper.insert(t)==1) return true;
        return false;
    }

    @Override
    public boolean delete(Integer userid, Integer id) {
        if(this.baseMapper.deleteByUserIdAndId(userid, id)==1)return true;
        return false;
    }

    @Override
    public boolean updata(T t) {
        if(this.baseMapper.updateByUserIdAndId(t)==1) return true;
        return false;
    }

    @Override
    public List getAll() {
        return this.baseMapper.selectAll();
    }

    @Override
    public List getAllPage(Integer pageNow, Integer pageSize) {
        Page page = null;

        List<T> list = new ArrayList<>();

        //获取查询数目
        int totalCount = this.baseMapper.getCount();

        page = new Page(pageNow,totalCount);

        page.setPageSize(pageSize);

        list = this.baseMapper.selectPage(page.getStartPos(), page.getPageSize());

        return list;
    }

    @Override
    public Integer getAllCount() {
        return this.baseMapper.getCount();
    }

    @Override
    public List getByUserId(Integer id) {
        return this.baseMapper.selectByUserId(id);
    }
}
