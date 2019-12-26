package com.example.demo03work.controller

import com.example.demo03work.code.logAnno.LogAnno
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

@RestController
@EnableSwagger2
open class UserLogController {

    /**
     * log测试方法
     */
    @LogAnno(operateType = "方法名称")
    @GetMapping("/hello")
    open fun hello() {
        println("外部调用此方法")
    }
}