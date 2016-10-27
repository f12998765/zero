package com.x.controller;

import com.x.model.Task;
import com.x.service.TaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @ModelAttribute("userid")
    public String getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return userid;
    }

    @ResponseBody
    @RequestMapping("/get")
    public Task getById( @RequestParam("id") int id){
        Task p = taskService.getTaskById(id);
        return p;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public List<Task> getAll(){
        return taskService.getAllTask();
    }

    @ResponseBody
    @RequestMapping("/getall/page")
    public List<Task> getAllPage(@RequestParam("num") int pageNow,@RequestParam(name = "size",defaultValue = "5") int pageSize){
        return taskService.getPage(pageNow,pageSize);
    }

    @ResponseBody
    @RequestMapping("/getall/sum")
    public int getAllCount(){
        return taskService.getCount();
    }

    @ResponseBody
    @RequestMapping("/gets")
    public List<Task> gets(@RequestParam("id") int id){
        return taskService.getTaskByProId(id);
    }

    @ResponseBody
    @RequestMapping("/gets/page")
    public List<Task> getsPage(@RequestParam("id") int id,@RequestParam("num") int pageNow,@RequestParam(name = "size",defaultValue = "5") int pageSize){
        return taskService.getPageByProId(pageNow,id,pageSize);
    }

    @ResponseBody
    @RequestMapping("/gets/sum")
    public int getsCount(@RequestParam("id") int id){
        return taskService.getCountByProId(id);
    }


    @ResponseBody
    @RequestMapping("/add")
    public boolean add(@ModelAttribute("userid") String userid,@RequestParam("info") String info,@RequestParam("xid") int xid){
        Task t = new Task(Integer.valueOf(userid),xid,info, Date.from(Instant.now()));
        return taskService.addTask(t);
    }

    @ResponseBody
    @RequestMapping("/del")
    public boolean del(@ModelAttribute("userid") String userid,@RequestParam("id") int id){
        return taskService.delTask(Integer.parseInt(userid),id);
    }

    @ResponseBody
    @RequestMapping("/put")
    public boolean updata(@ModelAttribute("userid") String userid,@RequestParam("id") int id,@RequestParam("info") String info){
        Task t = new Task(id,Integer.valueOf(userid),info);
        return taskService.updataTask(t);
    }

    @ResponseBody
    @RequestMapping("/build")
    public List<Task> getProByUserId(@RequestParam("id") int id){
        return taskService.getTaskByUserId(id);
    }
}
