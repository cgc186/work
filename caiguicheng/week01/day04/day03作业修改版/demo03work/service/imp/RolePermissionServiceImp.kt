package com.example.demo03work.service.imp

import com.example.demo03work.dao.IRolePermission
import com.example.demo03work.entity.RolePermission
import com.example.demo03work.service.RolePermissionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class RolePermissionServiceImp: RolePermissionService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuserRolePermission: IRolePermission

    /**
     * 为角色添加权限
     * @return 是否成功
     */
    override fun insertRolePermission(rolePermission: RolePermission): Int {
        return iuserRolePermission.insertRolePermission(rolePermission)
    }

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    override fun updateRolePermission(rolePermission: RolePermission): Int {
        return iuserRolePermission.updateRolePermission(rolePermission)
    }

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    override fun selectRolePermission(rolePermission: RolePermission): List<RolePermission> {
        return iuserRolePermission.selectRolePermission(rolePermission)
    }

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    override fun deleteRolePermission(rolePermission: RolePermission): Int {
        return iuserRolePermission.deleteRolePermission(rolePermission)
    }
}