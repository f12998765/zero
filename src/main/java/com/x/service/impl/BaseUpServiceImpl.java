package com.x.service.impl;

import com.x.inter.BaseMapper;
import com.x.inter.BaseUpMapper;
import com.x.service.BaseUpService;
import com.x.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class BaseUpServiceImpl<T> extends BaseServiceImpl<T> implements BaseUpService<T> {

    @Autowired
    private BaseUpMapper<T> baseUpMapper;

    @Override
    public List getByUpId(Integer up_id) {
        return this.baseUpMapper.selectByUpId(up_id);
    }

    @Override
    public List getByUpIdPage(Integer pageNow, Integer up_id, Integer pageSize) {

        Page page = null;

        List<T> list = new ArrayList<>();

        //获取查询数目
        int totalCount = this.baseUpMapper.selectCountByUpId(up_id);

        page = new Page(pageNow,totalCount);

        page.setPageSize(pageSize);

        list = this.baseUpMapper.selectPageByUpId(page.getStartPos(), page.getPageSize(), up_id);

        return list;
    }

    @Override
    public Integer getByUpIdCount(Integer up_id) {
        return null;
    }
}
