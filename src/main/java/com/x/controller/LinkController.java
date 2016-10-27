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
    public String getUser(@Value(value = "#{request.getAttribute('test')}") String userid)
    {
        return userid;
    }

    @Resource
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("/userbypro")
    public Map getUserByProId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinPro(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/userbytask")
    public Map getUserByTaskId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinTask(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/userbybug")
    public Map getUserByBugId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinBug(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/probyuser")
    public Map getProByUserId(@RequestParam("id") int id){
        Map<String,List<Project>> map = new HashMap();

        List<Project> list = linkService.getProByJoinUser(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/taskbyuser")
    public Map getTaskByUserId(@RequestParam("id") int id){
        Map<String,List<Task>> map = new HashMap();

        List<Task> list = linkService.getTaskByJoinUser(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/bugbyuser")
    public Map getBugByUserId(@RequestParam("id") int id){
        Map<String,List<Bug>> map = new HashMap();

        List<Bug> list = linkService.getBugByJoinUser(id);

        map.put("data",list);

        return map;

    }


    @ResponseBody
    @RequestMapping("/add/pro")
    public Map addLinkPro(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.addLinkPro(new UserPro(id,uid), Integer.parseInt(userid)));

        return map;

    }

    @ResponseBody
    @RequestMapping("/add/task")
    public Map addLinkTask(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.addLinkTask(new UserTask(id,uid), Integer.parseInt(userid)));

        return map;

    }

    @ResponseBody
    @RequestMapping("/add/bug")
    public Map addLinkBug(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.addLinkBug(new UserBug(id,uid), Integer.parseInt(userid)));

        return map;

    }

    @ResponseBody
    @RequestMapping("/del/pro")
    public Map delLinkPro(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.delLinkPro(new UserPro(id,uid), Integer.parseInt(userid)));

        return map;

    }

    @ResponseBody
    @RequestMapping("/del/task")
    public Map delLinkTask(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.delLinkTask(new UserTask(id,uid),Integer.parseInt(userid)));

        return map;

    }

    @ResponseBody
    @RequestMapping("/del/bug")
    public Map delLinkBug(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){
        Map<String,Boolean> map = new HashMap();

        map.put("data",linkService.delLinkBug(new UserBug(id,uid),Integer.parseInt(userid)));

        return map;

    }
}
