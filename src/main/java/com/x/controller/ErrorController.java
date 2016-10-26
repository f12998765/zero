package com.x.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xi on 16-10-23.
 */
@RestController
public class ErrorController {

    @ResponseBody
    @RequestMapping("/error")
    public Map<String,String> showErrorInfo(@RequestParam("info") String info){

        Map<String,String> map = new HashMap();

        map.put("error",info);
        return map;
    }


}
