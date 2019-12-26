package com.example.demo03work.entity

import java.util.*

/**
 * 说明: 用于做时间查找用户时候的区间
 * 编写人: 蔡
 * 编写时间: 2019-12-25
 * 修改时间:
 * 记录用户基本信息
 * @property fd 开始时间
 * @property ed 结束时间
 * @constructor
 */
class Order {
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var fd: Date? = null
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var ed: Date? = null
}