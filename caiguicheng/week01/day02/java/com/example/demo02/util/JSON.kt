package com.example.demo02.util

import com.example.demo02.entity.User
import com.google.gson.*

/**
 * JSON工具类
 */
class JSON {
    private val JSON_PARSER: JsonParser = JsonParser()


    /**
     *将 [sArr] 添加到这个组。
     * @param sArr 用户对象列表
     * @return JSON元素。
     */
    fun UserToJSON(sArr: List<User>): JsonElement {
        val ja = JsonArray()
        for (d in sArr) {
            val da = JsonObject()
            da.addProperty("id",d.id)
            da.addProperty("appid",d.appid)
            da.addProperty("username",d.username)
            da.addProperty("passwd",d.passwd)
            da.addProperty("createTime",d.createTime.toString())
            ja.add(da)
        }
        return ja
    }

    /**
     * @param arr JSON元素
     * @return 用户列表
     */
    fun jsonToList(arr: JsonElement): List<User> {
        return Gson().fromJson(arr, Array<User>::class.javaObjectType).asList()
    }
}