package com.example.demo03work.entity

import java.util.*

/**
 * 说明: 用户表实体
 * 编写人: 蔡
 * 编写时间: 2019-12-25
 * 修改时间:
 * 记录用户基本信息
 * @property id id
 * @property username 用户名
 * @property passwd 密码
 * @property email 邮箱
 * @property createTime 创建时间
 * @constructor 创建一个学生对象
 */
class User {
    var id: Int = 0
    var username: String = ""
    var passwd: String = ""
    var email: String = ""
    //格式化字符串,统一日期的格式
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var createTime: Date? = null
}