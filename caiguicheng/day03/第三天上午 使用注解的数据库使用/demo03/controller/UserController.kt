package com.example.demo03.controller

import com.example.demo03.entity.User
import com.example.demo03.mapper.UserMapper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 *
 */
@Api(tags = ["user"])
@RestController
@EnableSwagger2
class UserController {

    @Autowired
    lateinit var userMapper: UserMapper

    @ApiOperation("用户添加")
    @GetMapping("/addUser")
    fun addUser(user: User): Int {
        if (user.id!=0) {
            return userMapper.insertUser(user)
        }
        return 0
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser")
    fun deleteUser(id: Int): Int {
        return userMapper.deleteUser(id)
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    fun updateUser(user: User): Int {
        return userMapper.updateUser(user)
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
        return userMapper.selectUser(user)
    }
}