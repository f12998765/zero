package com.x.controller;

import com.x.model.Project;
import com.x.model.User;
import com.x.service.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.time.Instant;
import java.util.*;

/**
 * Created by Administrator on 2016/10/20.@RequestMapping("/project")
 */

@RestController
@RequestMapping("/pro")
public class ProjectController {

    @ModelAttribute("userid")
    public String getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return userid;
    }

    @Resource
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping("/get")
    public Project getById( @RequestParam("id") int id){
        return projectService.getProjectById(id);
    }

    @ResponseBody
    @RequestMapping("/getall")
    public List<Project> getAll(){
        return projectService.getAllProject();
    }

    @ResponseBody
    @RequestMapping("/getall/page")
    public List<Project> getAllPage(@RequestParam("num") int pageNow,@RequestParam(name = "size",defaultValue = "5") int pageSize){
        return projectService.getPage(pageNow,pageSize);
    }

    @ResponseBody
    @RequestMapping("/getall/sum")
    public int getAllCount(){
        return projectService.getCount();
    }

    @ResponseBody
    @RequestMapping("/add")
    public boolean add(@ModelAttribute("userid") String userid,@RequestParam("info") String info){

        Project p = new Project(Integer.valueOf(userid),info, Date.from(Instant.now()));
        return projectService.addProject(p);
    }

    @ResponseBody
    @RequestMapping("/del")
    public boolean del(@ModelAttribute("userid") String userid,@RequestParam("id") int id){
        return projectService.delProject(Integer.parseInt(userid),id);
    }

    @ResponseBody
    @RequestMapping("/put")
    public boolean updata(@ModelAttribute("userid") String userid,@RequestParam("id") int id,@RequestParam("info") String info){
        Project p = new Project(id, Integer.valueOf(userid),info);
        return projectService.updataProject(p);
    }

    @ResponseBody
    @RequestMapping("/build")
    public List<Project> getProByUserId(@RequestParam("id") int id){
        return projectService.getProByUserId(id);
    }


}
