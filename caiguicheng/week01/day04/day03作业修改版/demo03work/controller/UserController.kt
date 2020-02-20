package com.example.demo03work.controller

import com.example.demo03work.code.logAnno.LogAnno
import com.example.demo03work.entity.Order
import com.example.demo03work.entity.User
import com.example.demo03work.entity.UserData
import com.example.demo03work.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * 用户操作控制器类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Api(tags = ["user"])
@RestController
@EnableSwagger2
//@MapperScan("com.example.demo03work.dao")
open class UserController {

    //使用时候创建
    @Autowired
    @Lazy
    lateinit var userService: UserService

    @LogAnno(operateType = "用户添加")
    @ApiOperation("用户添加")
    @GetMapping("/addUser")
    open fun addUser(user: User): Int {
        println("id:")
        println(user.id)
        return userService.insertUser(user)
    }

    @LogAnno(operateType = "删除用户")
    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser")
    open fun deleteUser(id: Int): Int {
        return userService.deleteUser(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的用户列表
     */
    @LogAnno(operateType = "根据条件获得用户")
    @ApiOperation("查找用户信息")
    @PostMapping("/selectUser")
    open fun selectUser(user: User): List<User> {
        println("time")
        println(user.createTime)
        return userService.selectUser(user)
    }

    /**
     * 姓名模糊查询
     * @return 符合条件的用户列表
     */
    @LogAnno(operateType = "姓名模糊查询用户信息")
    @ApiOperation("查找用户信息")
    @PostMapping("/selectUserByName")
    open fun selectUserByName(name: String): List<User> {
        return userService.selectUserByName(name)
    }

    /**
     * 时间区间查询
     * @return 符合条件的用户列表
     */
    @LogAnno(operateType = "时间区间查询用户信息")
    @ApiOperation("查找用户信息")
    @PostMapping("/selectUserByTime")
    open fun selectUserByName(time: Order): List<User> {
        return userService.selectUserByTime(time)
    }

    /**
     * 显示用户信息列表
     * @return 用户列表
     */
    @LogAnno(operateType = "显示用户信息列表")
    @ApiOperation("显示用户信息列表")
    @PostMapping("/getUserList")
    open fun getUserList(): List<UserData> {
        return userService.getUserList()
    }

    @LogAnno(operateType = "修改用户信息")
    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    open fun updateUser(user: User): Int {
        return userService.updateUser(user)
    }
}