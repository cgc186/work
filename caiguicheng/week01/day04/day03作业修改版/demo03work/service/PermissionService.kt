package com.example.demo03work.service

import com.example.demo03work.entity.Permission
import org.apache.ibatis.annotations.Mapper

/**
 * 权限操作服务接口类
 * @author 蔡
 * @since 2019-12-25
 * 修改时间:
 */
@Mapper
interface PermissionService {
    /**
     * 插入权限
     * @param permission 权限对象
     * @return 是否成功
     */
    fun insertPermission(permission: Permission): Int

    /**
     * 更新权限信息
     * @return 是否成功
     */
    fun updatePermission(permission: Permission): Int

    /**
     * 根据条件获得权限
     * @return 权限列表
     */
    fun selectPermission(permission: Permission):List<Permission>

    /**
     * 删除权限
     * @return 是否成功
     */
    fun deletePermission(id:Int):Int
}