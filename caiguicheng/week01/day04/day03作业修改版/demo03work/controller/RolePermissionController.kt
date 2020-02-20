package com.example.demo03work.controller

import com.example.demo03work.code.logAnno.LogAnno
import com.example.demo03work.entity.RolePermission
import com.example.demo03work.service.RolePermissionService
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
 * 角色权限操作控制器类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Api(tags = ["rolePermission"])
@RestController
@EnableSwagger2
open class RolePermissionController {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var rolePermissionService: RolePermissionService

    /**
     * 为角色添加权限
     * @return 是否成功
     */
    @LogAnno(operateType = "角色添加权限")
    @ApiOperation("角色添加权限")
    @GetMapping("/addRolePermission")
    open fun insertRolePermission(rolePermission: RolePermission): Int{
        return rolePermissionService.insertRolePermission(rolePermission)
    }

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    @LogAnno(operateType = "角色删除权限")
    @ApiOperation("角色删除权限")
    @DeleteMapping("/deleteRolePermission")
    open fun updateRolePermission(rolePermission: RolePermission): Int{
        return rolePermissionService.deleteRolePermission(rolePermission)
    }

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    @LogAnno(operateType = "根据条件获得角色权限")
    @ApiOperation("根据条件获得角色权限")
    @PostMapping("/selectRolePermission")
    open fun selectRolePermission(rolePermission: RolePermission):List<RolePermission>{
        return rolePermissionService.selectRolePermission(rolePermission)
    }

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    @LogAnno(operateType = "修改权限信息")
    @ApiOperation("修改权限信息")
    @PostMapping("/updateRolePermission")
    open fun deleteRolePermission(rolePermission: RolePermission):Int{
        return rolePermissionService.updateRolePermission(rolePermission)
    }
}