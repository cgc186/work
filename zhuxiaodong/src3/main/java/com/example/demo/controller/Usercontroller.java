package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class Usercontroller {

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public Map<String,Object> userWebSocket(Map<String,Object>params){
        Map<String,Object> result=new HashMap<String, Object>();
        try {
            result.put("openResult", true);
        }catch (Exception e){

        }
        return result;
    }
}
