package com.example.demo03work.controller

import com.example.demo03work.code.logAnno.LogAnno
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
 * 角色操作控制器类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Api(tags = ["role"])
@RestController
@EnableSwagger2
open class RoleController {

    //使用时候创建
    @Autowired
    @Lazy
    lateinit var roleService: RoleService

    @LogAnno(operateType = "角色添加")
    @ApiOperation("角色添加")
    @GetMapping("/addRole")
    open fun addRole(role: Role): Int {
        println("id:")
        println(role.id)
        return roleService.insertRole(role)
    }

    @LogAnno(operateType = "删除角色")
    @ApiOperation("删除角色")
    @DeleteMapping("/deleteRole")
    open fun deleteUser(id: Int): Int {
        return roleService.deleteRole(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的角色列表
     */
    @LogAnno(operateType = "查找角色信息")
    @ApiOperation("查找角色信息")
    @PostMapping("/selectRole")
    open fun selectUser(role: Role): List<Role> {
//        println("time")
//        println(role.id)
        return roleService.selectRole(role)
    }

    /**
     * 显示列表
     * @return 角色列表
     */
    @LogAnno(operateType = "显示角色列表")
    @ApiOperation("查找角色信息")
    @PostMapping("/getRoleList")
    open fun getRoleNumber(): List<RoleNum> {
        return roleService.getRoleNumber()
    }

    @LogAnno(operateType = "修改角色信息")
    @ApiOperation("修改角色信息")
    @PostMapping("/updateRole")
    open fun updateUser(role: Role): Int {
        return roleService.updateRole(role)
    }
}