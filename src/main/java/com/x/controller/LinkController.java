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
    public String getUser(@Value(value = "#{request.getAttribute('userid')}") String userid)
    {
        return userid;
    }

    @Resource
    private LinkService linkService;

    @ResponseBody
    @RequestMapping("/userbypro")
    public List<User> getUserByProId(@RequestParam("id") int id){

        return linkService.getUserByJoinPro(id);

    }

    @ResponseBody
    @RequestMapping("/userbytask")
    public List<User> getUserByTaskId(@RequestParam("id") int id){

        return linkService.getUserByJoinTask(id);

    }

    @ResponseBody
    @RequestMapping("/userbybug")
    public List<User> getUserByBugId(@RequestParam("id") int id){

        return linkService.getUserByJoinBug(id);

    }

    @ResponseBody
    @RequestMapping("/probyuser")
    public List<Project> getProByUserId(@RequestParam("id") int id){

        return linkService.getProByJoinUser(id);

    }

    @ResponseBody
    @RequestMapping("/taskbyuser")
    public List<Task> getTaskByUserId(@RequestParam("id") int id){

        return linkService.getTaskByJoinUser(id);

    }

    @ResponseBody
    @RequestMapping("/bugbyuser")
    public List<Bug> getBugByUserId(@RequestParam("id") int id){

      return linkService.getBugByJoinUser(id);

    }


    @ResponseBody
    @RequestMapping("/add/pro")
    public boolean addLinkPro(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.addLinkPro(new UserPro(id,uid), Integer.parseInt(userid));

    }

    @ResponseBody
    @RequestMapping("/add/task")
    public boolean addLinkTask(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.addLinkTask(new UserTask(id,uid), Integer.parseInt(userid));

    }

    @ResponseBody
    @RequestMapping("/add/bug")
    public boolean addLinkBug(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.addLinkBug(new UserBug(id,uid), Integer.parseInt(userid));

    }

    @ResponseBody
    @RequestMapping("/del/pro")
    public boolean delLinkPro(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.delLinkPro(new UserPro(id,uid), Integer.parseInt(userid));

    }

    @ResponseBody
    @RequestMapping("/del/task")
    public boolean delLinkTask(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.delLinkTask(new UserTask(id,uid),Integer.parseInt(userid));

    }

    @ResponseBody
    @RequestMapping("/del/bug")
    public boolean delLinkBug(@RequestParam("id") int id,@RequestParam("uid") int uid,@ModelAttribute("userid") String userid){

        return linkService.delLinkBug(new UserBug(id,uid),Integer.parseInt(userid));

    }
}
