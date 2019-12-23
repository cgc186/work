package com.example.demo01.pojo

/**
 * 学生类
 * 记录学生基本信息
 * @property name 学生名称
 * @property age 学生年龄
 * @constructor 创建一个学生对象
 */
class Student(var name: String, var age: Int) {
    /**
     * toString()方法为了符合JSON格式重写
     * @return JSON格式信息
     */
    override fun toString(): String {
        return ("{\"name\":\"" + name + "\","
                + "\"age\":\"" + this.age + "\"}")
    }
}