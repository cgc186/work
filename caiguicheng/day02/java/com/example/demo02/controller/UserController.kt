package com.example.demo02.controller

import com.example.demo02.entity.User
import com.example.demo02.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 用户控制器
 */
@Api(tags = ["user"])
@RestController
@MapperScan("com.example.demo02.dao")
//扫描包 https://www.cnblogs.com/Java-Starter/p/8672719.html
class UserController {

    //使用时候创建
    @Autowired
    @Lazy
    lateinit var userService: UserService

    @ApiOperation("添加用户信息")
    @PutMapping("/addUser")
    fun addUser(user: User): Int {
        return userService.insertUser(user)
    }

    @ApiOperation("删除用户")
    @DeleteMapping("deleteUser")
    fun deleteUser(id: Int): Int {
        return userService.deleteUser(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的用户列表
     */
    @ApiOperation("查找用户信息")
    @PostMapping("/selectUser")
    fun selectUser(user: User): List<User> {
        println("time")
        println(user.createTime)
        return userService.selectUser(user)
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    fun updateUser(user: User): Int {
        return userService.updateUser(user)
    }


}