package com.x.util;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xi on 16-10-29.
 */
@Resource
public class UserUtil {

    public static String ParseUserId(String userid){

        if(userid.length()<6)
            return "用户名长度过短";
        else if(userid.length()>12)
            return "用户名长度过短";

        Pattern pattern = Pattern.compile("^[a-zA-Z]{1}([a-zA-Z0-9]){5,11}$");
        Matcher matcher= pattern.matcher(userid);
        boolean boo = matcher.matches();
        if(!boo){
            return "用户名格式错误";
        }

        return "ok";
    }



    public static String ParsePassword(String password){
        Pattern pattern = Pattern.compile("^[a-z0-9]{8,16}$");
        Matcher matcher= pattern.matcher(password);
        boolean boo = matcher.matches();
        if(!boo){
            return "密码格式错误";
        }

        return "ok";
    }
}
