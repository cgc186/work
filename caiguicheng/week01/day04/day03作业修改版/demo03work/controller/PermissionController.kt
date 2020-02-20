package com.example.demo03work.controller

import com.example.demo03work.code.logAnno.LogAnno
import com.example.demo03work.entity.Permission
import com.example.demo03work.service.PermissionService
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
 * 权限操作控制器类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Api(tags = ["permission"])
@RestController
@EnableSwagger2
open class PermissionController {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var permissionService: PermissionService

    @LogAnno(operateType = "权限添加")
    @ApiOperation("权限添加")
    @GetMapping("/addPermission")
    open fun addPermission(permission: Permission): Int {
        return permissionService.insertPermission(permission)
    }

    @LogAnno(operateType = "删除权限")
    @ApiOperation("删除权限")
    @DeleteMapping("/deletePermission")
    open fun deletePermission(id: Int): Int {
        return permissionService.deletePermission(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的用户列表
     */
    @LogAnno(operateType = "查找权限信息")
    @ApiOperation("查找权限信息")
    @PostMapping("/selectPermission")
    open fun selectPermission(permission: Permission): List<Permission> {
        return permissionService.selectPermission(permission)
    }

    @LogAnno(operateType = "修改权限信息")
    @ApiOperation("修改权限信息")
    @PostMapping("/updatePermission")
    open fun updatePermission(permission: Permission): Int {
        return permissionService.updatePermission(permission)
    }
}