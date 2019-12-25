package com.example.demo03work.service

import com.example.demo03work.entity.Role
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RoleService {
    /**
     * 插入角色
     * @return 是否成功
     */
    fun insertRole(role: Role): Int

    /**
     * 更新角色信息
     * @return 是否成功
     */
    fun updateRole(role: Role): Int

    /**
     * 根据条件获得角色
     * @return 用户列表
     */
    fun selectRole(role: Role):List<Role>

    /**
     * 删除角色
     * @return 是否成功
     */
    fun deleteRole(id:Int):Int
}