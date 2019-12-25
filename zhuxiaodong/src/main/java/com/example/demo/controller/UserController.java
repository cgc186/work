package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.Usermapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


/**
 *
 */
@Api(tags = "user")
@RestController
@EnableSwagger2
public class UserController {
    @Autowired
    private Usermapper usermapper;

    @ApiOperation(value = "用户添加")
    @GetMapping("/addUser")
    public int AddUser(User user){
        if (user!=null){
            if (user.getId()!=0){
                //是否可以添加此主键
                //if（）
            }
        }
        return usermapper.insertUser(user);
    }

    @ApiOperation(value="用户姓名查询")
    @GetMapping("/getAllUser")
    public List<User> getAll(String username){
        if (!username.isEmpty()){
            return usermapper.getAll(username);
        }else{
            return null;
        }
    }
}
