package com.example.demo03work.entity

import java.util.*

class UserData {
    var username: String = ""
    var passwd: String = ""
    var email: String = ""
    //格式化字符串,统一日期的格式
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var createTime: Date? = null
}