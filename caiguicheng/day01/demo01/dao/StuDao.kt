package com.example.demo01.dao

import com.example.demo01.pojo.Student
import com.example.demo01.service.StuJson
import com.google.gson.JsonElement

/**
 * 学生dao类
 */
class StuDao {
    /**
     * 创建学生列表转成JSON数据
     * @return 返回学生JSON数据
     */
    fun stuList(): JsonElement {
        var stuArr = Array<String>(4) {
            Student(it.toString() + "号同学", 20 + it).toString()
        }
        return StuJson.getStuList(stuArr)
    }
}