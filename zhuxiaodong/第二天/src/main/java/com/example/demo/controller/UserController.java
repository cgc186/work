package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户信息")
    @PutMapping("/addUser")
    public int AddUser(User user){
        System.out.println(user.getCreatetime());
        return userService.insertUser(user);
    }

    @ApiOperation("查询所有的数据")
    @GetMapping("/getSelectAll")
    public List<User> getAll(User user){
        return userService.getAll(user);
    }
}
