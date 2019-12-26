package com.example.demo03work.service

import com.example.demo03work.entity.RolePower
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RolePowerService {
    /**
     * 为角色添加权限
     * @return 是否成功
     */
    fun insertRolePower(rolePower: RolePower): Int

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    fun updateRolePower(rolePower: RolePower): Int

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    fun selectRolePower(rolePower: RolePower):List<RolePower>

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    fun deleteRolePower(rolePower: RolePower):Int
}