package com.x.controller;

import com.x.model.Project;
import com.x.model.User;
import com.x.service.UserService;
import com.x.util.TokenUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.HeaderParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xi on 16-10-23.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/signin")
    public Map SignIn(@RequestParam("userid") String userid,@RequestParam("password") String password){


        Map map = new HashMap();

        System.out.println(userid+"\t"+password);

        User u = userService.getUserByNameId(userid);

        if(u==null){
            map.put("error","用户不存在");
            return map;
        }

        if(password.equals(u.getPassword())){
            try {
                String token = TokenUtil.CreatToken(userid,"zeroOne",10800);
                map.put("data",token);
            } catch (Exception e) {
                map.put("error","登录失败");
            }
        }else{
            map.put("error","检查用户名和密码是否正确");
        }
        return map;
    }



    @ResponseBody
    @RequestMapping("signup")
    public Map SignUp(@RequestParam("username") String username, @RequestParam("userid") String userid, @RequestParam("password") String password){
        Map map = new HashMap();

        User u = userService.getUserByNameId(userid);

        if(u != null){
            map.put("error","用户名已使用");
            return map;
        }

        User user = new User(userid,password,username);

        if(userService.addUser(user)){
            String token = TokenUtil.CreatToken(userid,"zeroOne",10800);
            map.put("data",token);
        }else{
            map.put("error","注册失败");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("getall")
    public List<User> getAll(){
        return this.userService.getAllUser();
    }




}
