package com.example.demo03work.controller

import com.example.demo03work.entity.Power
import com.example.demo03work.service.PowerService
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
@Api(tags = ["power"])
@RestController
@EnableSwagger2
@MapperScan("com.example.demo03work.dao")
class PowerController {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var powerService: PowerService

    @ApiOperation("权限添加")
    @GetMapping("/addPower")
    fun addPower(power: Power): Int {
        return powerService.insertPower(power)
    }

    @ApiOperation("删除权限")
    @DeleteMapping("/deletePower")
    fun deletePower(id: Int): Int {
        return powerService.deletePower(id)
    }

    /**
     * 根据条件获得用户
     * @return 符合条件的用户列表
     */
    @ApiOperation("查找权限信息")
    @PostMapping("/selectPower")
    fun selectPower(power: Power): List<Power> {
        return powerService.selectPower(power)
    }

    @ApiOperation("修改权限信息")
    @PostMapping("/updatePower")
    fun updatePower(power: Power): Int {
        return powerService.updatePower(power)
    }
}