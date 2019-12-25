package com.example.demo03work.service

import com.example.demo03work.entity.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserService {

    /**
     * 插入用户
     * @return 是否成功
     */
    fun insertUser(user: User): Int

    /**
     * 更新用户信息
     * @return 是否成功
     */
    fun updateUser(user: User): Int

    /**
     * 根据条件获得用户
     * @return 用户列表
     */
    fun selectUser(user:User):List<User>

    /**
     * 删除用户
     * @return 是否成功
     */
    fun deleteUser(id:Int):Int
}