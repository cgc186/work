package com.example.demo03work.service

import com.example.demo03work.entity.Role
import com.example.demo03work.entity.RoleNum
import org.apache.ibatis.annotations.Mapper

/**
 * 角色操作服务接口类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
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
     *
     */
    fun getRoleNumber():List<RoleNum>

    /**
     * 删除角色
     * @return 是否成功
     */
    fun deleteRole(id:Int):Int
}