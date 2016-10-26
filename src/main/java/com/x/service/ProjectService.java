package com.x.service;

import com.x.model.Project;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public interface ProjectService {

    public Project getProjectById(int id);

    public List<Project> getAllProject();

    public boolean addProject(Project project);

    public boolean delProject(int userid,int id);

    public boolean updataProject(Project project);

    public List<Project> getPage(int pageNow,int pageSize);

    public int getCount();


    public List<Project> getProByUserId(int id);

}
