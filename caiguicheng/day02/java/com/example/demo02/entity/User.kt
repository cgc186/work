package com.example.demo02.entity

import java.util.*

/**
 * 用户类
 * 记录学生基本信息
 * @property name 学生名称
 * @property age 学生年龄
 * @constructor 创建一个学生对象
 */
class User {
    var id: Int = 0
    var appid: Int = 0
    var username: String = ""
    var passwd: String = ""
    //格式化字符串,统一日期的格式
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var createTime: Date? = null
}