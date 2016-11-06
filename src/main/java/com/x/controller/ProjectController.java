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
    public int getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return Integer.parseInt(userid);
    }

    @Resource
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping("/get")
    public Map<String, Object> getById(@RequestParam("id") String pro_id){
        Map<String, Object> map=new HashMap<>();

        if(pro_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(pro_id);
            Project p = projectService.getProjectById(id);
            map.put("data",p);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public Map getAll(){
        Map map = new HashMap();
        map.put("data",projectService.getAllProject());
        return map;
    }

    @ResponseBody
    @RequestMapping("/getall/page")
    public Map getAllPage(@RequestParam("num") String pageNow_,@RequestParam(name = "size",defaultValue = "5") String pageSize_){
        Map map = new HashMap();
        if(pageNow_==""||pageSize_==""){
            map.put("error","参数为空");
            return map;
        }
        try{
            int pageNow=Integer.parseInt(pageNow_);
            int pageSize=Integer.parseInt(pageSize_);
            List<Project> projects = projectService.getPage(pageNow,pageSize);
            map.put("data",projects);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/getall/sum")
    public Map getAllCount(){
        Map map = new HashMap();
        map.put("data",projectService.getCount());
        return map;
    }

    @ResponseBody
    @RequestMapping("/add")
    public Map add(@ModelAttribute("userid") int userid, @RequestParam("info") String info){
        Map map = new HashMap();
        if(info==""){
            map.put("error","参数为空");
            return map;
        }
        Project p = new Project(userid,info, Date.from(Instant.now()));
        map.put("data",projectService.addProject(p));
        return map;
    }

    @ResponseBody
    @RequestMapping("/del")
    public Map del(@ModelAttribute("userid") int userid, @RequestParam("id") String pro_id){
        Map map=new HashMap<>();
        if(pro_id==""){
            map.put("error","参数为空");
            return map;
        }
        try{
            int id= Integer.parseInt(pro_id);
            if(projectService.getProjectById(id)==null){
                map.put("error","该项目不存在");
                return map;
            }
            boolean boo = projectService.delProject(userid,id);
            map.put("data",boo);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/put")
    public Map updata(@ModelAttribute("userid") int userid, @RequestParam("id") String pro_id, @RequestParam("info") String info){
        Map map = new HashMap();

        if(pro_id==""||info==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(pro_id);
            if(projectService.getProjectById(id)==null){
                map.put("error","该项目不存在");
                return map;
            }
            Project p = new Project(id, userid,info);
            boolean boo = projectService.updataProject(p);
            map.put("data",boo);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/build")
    public Map<String, Object> getProByUserId(@RequestParam("id") String user_id){
        Map<String, Object> map = new HashMap<>();
        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            List<Project> projects = projectService.getProByUserId(id);
            map.put("data",projects);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }


}
