package com.x.service.impl;

import com.x.inter.ProjectMapper;
import com.x.model.Project;
import com.x.service.ProjectService;
import com.x.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/10/20.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectMapper projectMapper;


    public Project getProjectById(int id) {
        return this.projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Project> getAllProject() {
        return this.projectMapper.selectAll();
    }

    @Override
    public boolean addProject(Project project) {

        if(this.projectMapper.insertSelective(project)==1)  return true;

        return false;
    }

    @Override
    public boolean delProject(int userid,int id) {
        if(this.projectMapper.deleteByUserIdAndProId(userid,id) == 1)
            return true;

        return false;
    }


    @Override
    public boolean updataProject(Project project) {
        if( this.projectMapper.updateByUserIdAndProId(project) ==1)
            return true;
        return false;
    }

    @Override
    public List<Project> getPage(int pageNow, int pageSize) {
        Page page = null;

        List<Project> bugs = new ArrayList<Project>();

        //获取查询数目
        int totalCount = this.projectMapper.getCount();

        page = new Page(pageNow,totalCount);

        page.setPageSize(pageSize);

        bugs = this.projectMapper.selectPage(page.getStartPos(), page.getPageSize());

        return bugs;
    }

    @Override
    public int getCount() {
        return this.projectMapper.getCount();
    }

    @Override
    public List<Project> getProByUserId(int id) {
        return this.projectMapper.selectByUserId(id);
    }
}
