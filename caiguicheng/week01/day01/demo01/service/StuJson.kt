package com.example.demo01.service

import com.example.demo01.pojo.Student
import com.google.gson.*

/**
 * JSON工具类
 */
object StuJson {

    private val JSON_PARSER: JsonParser = JsonParser()

    /**
     *将 [sArr] 添加到这个组。
     * @return JSON元素。
     */
    fun getStuList(sArr: Array<String>): JsonElement {

        val ja = JsonArray()
        for (d in sArr) {
            val da = JsonObject()
            da.add("Student", JSON_PARSER.parse(d))
            ja.add(da)
        }
        return ja
    }

    /**
     *将 [sArr] 添加到这个组。
     * @param sArr 学生对象列表
     * @return JSON元素。
     */
    fun getStuList(sArr: Array<Student>): JsonElement {

        val ja = JsonArray()
        for (d in sArr) {
            val da = JsonObject()
            da.addProperty("name",d.name)
            da.addProperty("age",d.age)
            ja.add(da)
        }
        return ja
    }

    /**
     * @param arr JSON元素
     * @return 学生列表
     */
    fun jsonToList(arr: JsonElement): List<Student> {
        return Gson().fromJson(arr, Array<Student>::class.javaObjectType).asList()
    }
}