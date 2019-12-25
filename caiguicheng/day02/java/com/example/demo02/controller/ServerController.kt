package com.example.demo02.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 服务器接口示例
 */
@Api(tags = ["Server"])
@RestController
open class ServerController {

    @ApiOperation(value = "提供一个简单的对外接口")
    @GetMapping("/getServer")
    fun serverApi(): String {
        return "hello"
    }
}