package com.example.demo05.controller

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody


open class UserController {


    @RequestMapping(method = [RequestMethod.POST], consumes = ["application/json"])
    @ResponseBody
    open fun userWebSocket(@RequestBody params: Map<String, Any>): Map<String, Any> {
        val result = hashMapOf<String, Any>()

        try {
            result["openResult"] = true
        } catch (e: Exception) {

        }
        return result
    }
}