package com.example.demo03work.entity

import java.util.*

class Order {
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var fd: Date? = null
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    var ed: Date? = null
}