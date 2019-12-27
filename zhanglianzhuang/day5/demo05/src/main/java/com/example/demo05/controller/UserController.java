package com.example.demo05.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

public class UserController {

	@RequestMapping(method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody Map<String,Object> userWebSocket(@RequestBody Map<String,Object> params){
		Map<String,Object> result=new HashMap<String, Object>();
		try {
			result.put("openResult",true);
		}catch (Exception e){
		}
		return result;
	}
}
