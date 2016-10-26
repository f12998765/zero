package com.x.controller;

import com.x.model.Project;
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
    public String getUser(@Value(value = "#{request.getAttribute('test')}") String userid)
    {
        return userid;
    }

    @Resource
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping("/get")
    public Project getById( @RequestParam("id") int id){
        Project p = projectService.getProjectById(id);
        return p;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public Map getAll(){

        Map m = new HashMap();
        m.put("data",projectService.getAllProject());
        return m;
    }

    @ResponseBody
    @RequestMapping("/test")
    public Map getall(@ModelAttribute("userid") String userid){
        System.out.println(userid);
        Map m = new HashMap();
        //m.put("data",projectService.getAllProject());
        m.put("data",userid);
        return m;
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
    public boolean add(@RequestParam("user_id") int user_id,@RequestParam("info") String info){

        Project p = new Project(user_id,info, Date.from(Instant.now()));
        return projectService.addProject(p);
    }

    @ResponseBody
    @RequestMapping("/del")
    public boolean del(@RequestParam("id") int id){
        return projectService.delProject(id);
    }

    @ResponseBody
    @RequestMapping("/set")
    public boolean updata(@RequestParam("user_id") int user_id,@RequestParam("id") int id,@RequestParam("info") String info){
        Project p = new Project(id,user_id,info);
        return projectService.updataProject(p);
    }

    @ResponseBody
    @RequestMapping("/build")
    public List<Project> getProByUserId(@RequestParam("id") int id){
        return projectService.getProByUserId(id);
    }

}
