package com.example.demo03work.dao

import com.example.demo03work.entity.Order
import com.example.demo03work.entity.User
import com.example.demo03work.entity.UserData
import org.springframework.stereotype.Component

/**
 * 用户操作接口类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Component
interface IUser {

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
    fun selectUser(user: User): List<User>

    /**
     * 姓名模糊查询
     * @return 用户列表
     */
    fun selectUserByName(name: String): List<User>

    /**
     * 时间区间查询
     * @return 用户列表
     */
    fun selectUserByTime(time: Order): List<User>

    /**
     * 显示列表
     * @return 用户列表
     */
    fun getUserList(): List<UserData>

    /**
     * 删除用户
     * @return 是否成功
     */
    fun deleteUser(id: Int): Int
}