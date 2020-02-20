package com.example.demo03work.controller

import com.example.demo03work.entity.Role
import com.example.demo03work.entity.RoleNum
import com.example.demo03work.entity.User
import com.example.demo03work.service.RoleService
import com.example.demo03work.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 *
 */
@Api(tags = ["role"])
@RestController
@EnableSwagger2
class RoleController {

    //使用时候创建
    @Autowired
    @Lazy
    lateinit var roleService: RoleService

    @ApiOperation("角色添加")
    @GetMapping("/addRole")
    fun addRole(role: Role): Int {
        println("id:")
        println(role.id)
        return roleService.insertRole(role)
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/deleteRole")
    fun deleteUser(id: Int): Int {
        return roleService.deleteRole(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的角色列表
     */
    @ApiOperation("查找角色信息")
    @PostMapping("/selectRole")
    fun selectUser(role: Role): List<Role> {
//        println("time")
//        println(role.id)
        return roleService.selectRole(role)
    }

    /**
     * 显示列表
     * @return 角色列表
     */
    @ApiOperation("查找角色信息")
    @PostMapping("/getList")
    fun getRoleNumber(): List<RoleNum> {
        return roleService.getRoleNumber()
    }

    @ApiOperation("修改角色信息")
    @PostMapping("/updateRole")
    fun updateUser(role: Role): Int {
        return roleService.updateRole(role)
    }
}