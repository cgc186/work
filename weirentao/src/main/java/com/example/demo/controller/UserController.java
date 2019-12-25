package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Api(tags="user")
@RestController
@EnableSwagger2
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation(value ="用户添加")
    @GetMapping("/addUser")
     public int AddUser(User user){
        if(user!=null){
            if(user.getId()!=0) {
                //是否可以添加此主键
            }
        }
         return userMapper.insertUser(user);
     }
    @ApiOperation(value ="更新信息")
    @PostMapping("/addUser")
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    @ApiOperation(value ="删除信息")
    @GetMapping("/deleteUser")
    public int deleteUser(int id){
        return userMapper.deleteUser(id);
    }
    @ApiOperation(value ="查询信息")
    @GetMapping("/selectAllUsers")
    public List<User> selectAllUsers(){
        return userMapper.selectAllUsers();
    }
}
