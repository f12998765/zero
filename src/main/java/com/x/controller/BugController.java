package com.x.controller;

import com.x.model.Bug;
import com.x.service.BugService;
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
@RequestMapping("/bug")
public class BugController {
    @Resource
    private BugService bugService;
    @Resource
    private TaskService taskService;

    @ModelAttribute("userid")
    public int getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return Integer.parseInt(userid);
    }
    @ResponseBody
    @RequestMapping("/get")
    public Map getById(@RequestParam("id") String bug_id){
        Map map = new HashMap();


        if(bug_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(bug_id);
            Bug b = bugService.getBugById(id);
            map.put("data",b);
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
        map.put("data",bugService.getAllBug());
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
            List<Bug> bugs = bugService.getPage(pageNow,pageSize);
            map.put("data",bugs);
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
        map.put("data",bugService.getCount());
        return map;
    }


    @ResponseBody
    @RequestMapping("/gets")
    public Map gets(@RequestParam("id") String task_id){
        Map map = new HashMap();

        if(task_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            if(taskService.getTaskById(id)==null){
                map.put("error","该任务不存在");
                return map;
            }
            List<Bug> bugs = bugService.getBugByTaskId(id);
            map.put("data",bugs);
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
    public Map getsPage(@RequestParam("id") String task_id,@RequestParam("num") String pageNow_,@RequestParam(name = "size",defaultValue = "5") String pageSize_){
        Map map = new HashMap();

        if(task_id==""||pageNow_==""||pageSize_==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            if(taskService.getTaskById(id)==null){
                map.put("error","该任务不存在");
                return map;
            }
            int pageNow=Integer.parseInt(pageNow_);
            int pageSize=Integer.parseInt(pageSize_);
            List<Bug> bugs =  bugService.getPageByTaskId(pageNow,id,pageSize);
            map.put("data",bugs);
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
    public Map getsCount(@RequestParam("id") String task_id){
        Map map = new HashMap();

        if(task_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            if(taskService.getTaskById(id)==null){
                map.put("error","该任务不存在");
                return map;
            }
            int sum=bugService.getCountByTaskId(id);
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
            int task_id= Integer.parseInt(xid);
            if(taskService.getTaskById(task_id)==null){
                map.put("error","该任务不存在");
                return map;
            }
            Bug b = new Bug(userid,task_id,info, Date.from(Instant.now()));
            map.put("data",bugService.addBug(b));
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
    public Map del(@ModelAttribute("userid") int userid,@RequestParam("id") String bug_id){
        Map map=new HashMap();

        if(bug_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(bug_id);
            if(bugService.getBugById(id)==null){
                map.put("error","该Bug不存在");
                return map;
            }
            map.put("data",bugService.delBug(userid,id));
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
    public Map updata(@ModelAttribute("userid") int userid,@RequestParam("id") String bug_id,@RequestParam("info") String info){
        Map map=new HashMap();

        if(bug_id==""||info==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(bug_id);
            if(bugService.getBugById(id)==null){
                map.put("error","该Bug不存在");
                return map;
            }
            Bug t = new Bug(id,userid,info);
            map.put("data",bugService.updataBug(t));
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
    public Map getBugByUserId(@RequestParam("id") String user_id){
        Map map = new HashMap();

        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            List<Bug> bugs = bugService.getBugByUserId(id);
            map.put("data",bugs);
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;
    }
}
