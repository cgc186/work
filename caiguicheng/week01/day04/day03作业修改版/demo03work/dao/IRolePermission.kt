package com.example.demo03work.dao

import com.example.demo03work.entity.RolePermission
import org.springframework.stereotype.Component

/**
 * 用户角色操作接口类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Component
interface IRolePermission {
    /**
     * 为角色添加权限
     * @return 是否成功
     */
    fun insertRolePermission(rolePermission: RolePermission): Int

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    fun updateRolePermission(rolePermission: RolePermission): Int

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    fun selectRolePermission(rolePermission: RolePermission):List<RolePermission>

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    fun deleteRolePermission(rolePermission: RolePermission):Int
}