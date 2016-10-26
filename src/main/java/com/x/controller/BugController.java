package com.x.controller;

import com.x.model.Bug;
import com.x.service.BugService;
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
@RequestMapping("/bug")
public class BugController {
    @Resource
    private BugService bugService;

    @ResponseBody
    @RequestMapping("/get")
    public Bug getById(@RequestParam("id") int id){
        Bug p = bugService.getBugById(id);
        return p;
    }

    @ResponseBody
    @RequestMapping("/getall")
    public List<Bug> getAll(){
        return bugService.getAllBug();
    }

    @ResponseBody
    @RequestMapping("/getall/page")
    public List<Bug> getAllPage(@RequestParam("num") int pageNow,@RequestParam(name = "size",defaultValue = "5") int pageSize){
        return bugService.getPage(pageNow,pageSize);
    }

    @ResponseBody
    @RequestMapping("/getall/sum")
    public int getAllCount(){
        return bugService.getCount();
    }


    @ResponseBody
    @RequestMapping("/gets")
    public List<Bug> gets(@RequestParam("id") int id){
        return bugService.getBugByTaskId(id);
    }

    @ResponseBody
    @RequestMapping("/gets/page")
    public List<Bug> getsPage(@RequestParam("id") int id,@RequestParam("num") int pageNow,@RequestParam(name = "size",defaultValue = "5") int pageSize){
        return bugService.getPageByTaskId(pageNow,id,pageSize);
    }

    @ResponseBody
    @RequestMapping("/gets/sum")
    public int getsCount(@RequestParam("id") int id){
        return bugService.getCountByTaskId(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    public boolean add(@RequestParam("user_id") int user_id,@RequestParam("info") String info,@RequestParam("xid") int xid){
        Bug b = new Bug(user_id,xid,info, Date.from(Instant.now()));
        return bugService.addBug(b);
    }

    @ResponseBody
    @RequestMapping("/del")
    public boolean del(@RequestParam("id") int id){
        return bugService.delBug(id);
    }

    @ResponseBody
    @RequestMapping("/set")
    public boolean updata(@RequestParam("id") int id,@RequestParam("user_id") int user_id,@RequestParam("xid") int xid,@RequestParam("info") String info){
        Bug t = new Bug(id,user_id,xid,info);
        return bugService.updataBug(t);
    }

    @ResponseBody
    @RequestMapping("/build")
    public List<Bug> getProByUserId(@RequestParam("id") int id){
        return bugService.getBugByUserId(id);
    }
}
