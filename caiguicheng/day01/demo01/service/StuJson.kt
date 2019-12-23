package com.example.demo01.service

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser

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
            da.add("stu", JSON_PARSER.parse(d))
            ja.add(da)
        }
        return ja
    }


}