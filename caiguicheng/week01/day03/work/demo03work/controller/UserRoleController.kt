package com.example.demo03work.controller

import com.example.demo03work.entity.UserRole
import com.example.demo03work.service.UserRoleService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Api(tags = ["UserRole"])
@RestController
@EnableSwagger2
class UserRoleController {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var userRoleService: UserRoleService

    /**
     * 为用户添加角色
     * @return 是否成功
     */
    @ApiOperation("用户添加角色")
    @GetMapping("/addUserRole")
    fun insertUserRole(userRole: UserRole): Int{
        return userRoleService.insertUserRole(userRole)
    }

    /**
     * 删除用户的某个角色
     * @return 是否成功
     */
    @ApiOperation("删除权限")
    @DeleteMapping("/deleteUserRole")
    fun deleteUserRole(userRole: UserRole):Int{
        return userRoleService.deleteUserRole(userRole)
    }

    /**
     * 根据条件获得用户角色表
     * @return 用户角色列表
     */
    @ApiOperation("查找权限信息")
    @PostMapping("/selectUserRole")
    fun selectUserRole(userRole: UserRole):List<UserRole>{
        return userRoleService.selectUserRole(userRole)
    }

    /**
     * 更新用户角色信息
     * @return 是否成功
     */
    @ApiOperation("修改用户角色信息")
    @PostMapping("/updateUserRole")
    fun updateUserRole(userRole: UserRole): Int{
        return userRoleService.updateUserRole(userRole)
    }
}