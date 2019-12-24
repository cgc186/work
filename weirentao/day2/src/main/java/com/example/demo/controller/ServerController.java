package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Server")
@RestController
public class ServerController {
   @ApiOperation(value = "提供一个简单的对外接口")
    @GetMapping("/getserver")
    public String ServerApi(){
       return"hello";
   }
}
