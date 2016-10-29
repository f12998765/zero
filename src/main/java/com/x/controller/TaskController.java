package com.x.controller;

import com.x.model.Task;
import com.x.service.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/20.
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @ModelAttribute("userid")
    public int getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return Integer.parseInt(userid);
    }

    @ResponseBody
    @RequestMapping("/get")
    public Map getById( @RequestParam("id") String task_id){
        Map map = new HashMap();

        if(task_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            Task t = taskService.getTaskById(id);
            map.put("data",t);
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
        map.put("data",taskService.getAllTask());
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
            List<Task> tasks = taskService.getPage(pageNow,pageSize);
            map.put("data",tasks);
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
        map.put("data",taskService.getCount());
        return map;
    }

    @ResponseBody
    @RequestMapping("/gets")
    public Map gets(@RequestParam("id") String pro_id){
        Map map = new HashMap();


        if(pro_id==""){
            map.put("error","参数为空");
            return map;
        }


        try{
            int id= Integer.parseInt(pro_id);
            List<Task> tasks = taskService.getTaskByProId(id);
            map.put("data",tasks);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/gets/page")
    public Map getsPage(@RequestParam("id") String pro_id,@RequestParam("num") String pageNow_,@RequestParam(name = "size",defaultValue = "5") String pageSize_){
        Map map = new HashMap();

        if(pro_id==""||pageNow_==""||pageSize_==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(pro_id);
            int pageNow=Integer.parseInt(pageNow_);
            int pageSize=Integer.parseInt(pageSize_);
            List<Task> tasks = taskService.getPageByProId(pageNow,id,pageSize);
            map.put("data",tasks);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/gets/sum")
    public Map getsCount(@RequestParam("id") String pro_id){
        Map map = new HashMap();

        if(pro_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(pro_id);
            int sum=taskService.getCountByProId(id);
            map.put("data",sum);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/add")
    public Map add(@ModelAttribute("userid") int userid,@RequestParam("info") String info,@RequestParam("xid") String xid){
        Map map = new HashMap();

        if(info==""||xid==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int pro_id= Integer.parseInt(xid);
            Task t = new Task(userid,pro_id,info, Date.from(Instant.now()));

            map.put("data",taskService.addTask(t));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/del")
    public Map del(@ModelAttribute("userid") int userid,@RequestParam("id") String task_id){
        Map map=new HashMap();

        if(task_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            map.put("data",taskService.delTask(userid,id));
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
    public Map updata(@ModelAttribute("userid") int userid,@RequestParam("id") String task_id,@RequestParam("info") String info){
        Map map=new HashMap();

        if(task_id==""||info==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            Task t = new Task(id,userid,info);
            map.put("data",taskService.updataTask(t));
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
    public Map getTaskByUserId(@RequestParam("id") String user_id){
        Map map = new HashMap();

        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            List<Task> tasks = taskService.getTaskByUserId(id);
            map.put("data",tasks);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }
}
