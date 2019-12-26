package com.example.demo03work.dao

import com.example.demo03work.entity.UserRole
import org.springframework.stereotype.Component

/**
 * 角色权限操作接口类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间
 */
@Component
interface IUserRole {
    /**
     * 为用户添加角色
     * @return 是否成功
     */
    fun insertUserRole(userRole: UserRole): Int

    /**
     * 更新用户角色信息
     * @return 是否成功
     */
    fun updateUserRole(userRole: UserRole): Int

    /**
     * 根据条件获得用户角色表
     * @return 用户角色列表
     */
    fun selectUserRole(userRole: UserRole):List<UserRole>

    /**
     * 删除用户的某个角色
     * @return 是否成功
     */
    fun deleteUserRole(userRole: UserRole):Int
}