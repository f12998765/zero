package com.x.controller;

import com.x.model.Bug;
import com.x.model.Project;
import com.x.model.Task;
import com.x.model.User;
import com.x.service.LinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("/user/pro")
    public Map getUserByProId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinPro(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/user/task")
    public Map getUserByTaskId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinTask(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/user/bug")
    public Map getUserByBugId(@RequestParam("id") int id){
        Map<String,List<User>> map = new HashMap();

        List<User> list = linkService.getUserByJoinBug(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/pro/user")
    public Map getProByUserId(@RequestParam("id") int id){
        Map<String,List<Project>> map = new HashMap();

        List<Project> list = linkService.getProByJoinUser(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/task/user")
    public Map getTaskByUserId(@RequestParam("id") int id){
        Map<String,List<Task>> map = new HashMap();

        List<Task> list = linkService.getTaskByJoinUser(id);

        map.put("data",list);

        return map;

    }

    @ResponseBody
    @RequestMapping("/bug/user")
    public Map getBugByUserId(@RequestParam("id") int id){
        Map<String,List<Bug>> map = new HashMap();

        List<Bug> list = linkService.getBugByJoinUser(id);

        map.put("data",list);

        return map;

    }

}
