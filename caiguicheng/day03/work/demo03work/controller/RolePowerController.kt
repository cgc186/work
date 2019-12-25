package com.example.demo03work.controller

import com.example.demo03work.entity.Power
import com.example.demo03work.entity.RolePower
import com.example.demo03work.service.PowerService
import com.example.demo03work.service.RolePowerService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Api(tags = ["rolePower"])
@RestController
@EnableSwagger2
class RolePowerController {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var rolePowerService: RolePowerService

    /**
     * 为角色添加权限
     * @return 是否成功
     */
    @ApiOperation("角色添加权限")
    @GetMapping("/addRolePower")
    fun insertRolePower(rolePower: RolePower): Int{
        return rolePowerService.insertRolePower(rolePower)
    }

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    @ApiOperation("角色删除权限")
    @DeleteMapping("/deleteRolePower")
    fun updateRolePower(rolePower: RolePower): Int{
        return rolePowerService.deleteRolePower(rolePower)
    }

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    @ApiOperation("查找权限信息")
    @PostMapping("/selectRolePower")
    fun selectRolePower(rolePower: RolePower):List<RolePower>{
        return rolePowerService.selectRolePower(rolePower)
    }

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    @ApiOperation("修改权限信息")
    @PostMapping("/updateRolePower")
    fun deleteRolePower(rolePower: RolePower):Int{
        return rolePowerService.updateRolePower(rolePower)
    }
}