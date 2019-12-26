package com.example.demo04.controller

import com.example.demo04.code.logAnno.LogAnno
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger2.annotations.EnableSwagger2

@RestController
@EnableSwagger2
open class UserLogController {

    @LogAnno(operateType = "方法名称")
    @GetMapping("/hello")
    open fun hello() {
        println("外部调用此方法")
    }
}