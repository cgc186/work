package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "server")
@RestController
public class ServerController {

    @ApiOperation(value = "提供一个对外接口")
    @GetMapping("/getServer")
    public String ServerApi(){
        return "hello";
    }

}
