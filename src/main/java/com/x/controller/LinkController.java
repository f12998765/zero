package com.x.controller;

import com.x.model.*;
import com.x.service.LinkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xi on 16-10-26.
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @ModelAttribute("userid")
    public int getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return Integer.parseInt(userid);
    }
    @Resource
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("/userbypro")
    public Map getUserByProId(@RequestParam("id") String pro_id){
        Map map = new HashMap();

        if(pro_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(pro_id);
            map.put("data",linkService.getUserByJoinPro(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/userbytask")
    public Map getUserByTaskId(@RequestParam("id") String task_id){
        Map map = new HashMap();

        if(task_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(task_id);
            map.put("data",linkService.getUserByJoinTask(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/userbybug")
    public Map getUserByBugId(@RequestParam("id") String bug_id){
        Map map = new HashMap();

        if(bug_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(bug_id);
            map.put("data",linkService.getUserByJoinBug(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/probyuser")
    public Map getProByUserId(@RequestParam("id") String user_id){
        Map map = new HashMap();

        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            map.put("data",linkService.getProByJoinUser(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/taskbyuser")
    public Map getTaskByUserId(@RequestParam("id") String user_id){
        Map map = new HashMap();

        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            map.put("data",linkService.getTaskByJoinUser(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/bugbyuser")
    public Map getBugByUserId(@RequestParam("id") String user_id){
        Map map = new HashMap();

        if(user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id= Integer.parseInt(user_id);
            map.put("data",linkService.getBugByJoinUser(id));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }


    @ResponseBody
    @RequestMapping("/add/pro")
    public Map addLinkPro(@RequestParam("id") String pro_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(pro_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(pro_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.addLinkPro(new UserPro(id,uid), userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/add/task")
    public Map addLinkTask(@RequestParam("id") String task_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(task_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(task_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.addLinkTask(new UserTask(id,uid), userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/add/bug")
    public Map addLinkBug(@RequestParam("id") String bug_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(bug_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(bug_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.addLinkBug(new UserBug(id,uid), userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/del/pro")
    public Map delLinkPro(@RequestParam("id") String pro_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(pro_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(pro_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.delLinkPro(new UserPro(id,uid), userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/del/task")
    public Map delLinkTask(@RequestParam("id") String task_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(task_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(task_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.delLinkTask(new UserTask(id,uid),userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/del/bug")
    public Map delLinkBug(@RequestParam("id") String bug_id,@RequestParam("uid") String user_id,@ModelAttribute("userid") int userid){
        Map map = new HashMap();

        if(bug_id==""||user_id==""){
            map.put("error","参数为空");
            return map;
        }

        try{
            int id = Integer.parseInt(bug_id);
            int uid = Integer.parseInt(user_id);
            map.put("data",linkService.delLinkBug(new UserBug(id,uid),userid));
        }catch (NumberFormatException no){
            map.put("error","请求参数类型错误");
        }catch (Exception e){
            map.put("error","服务器异常");
            e.printStackTrace();
        }
        return map;

    }
}
