package com.example.demo03work.service.imp

import com.example.demo03work.dao.IPermission
import com.example.demo03work.entity.Permission
import com.example.demo03work.service.PermissionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class PermissionServiceImp : PermissionService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iPermission: IPermission

    /**
     * 插入权限
     * @return 是否成功
     */
    override fun insertPermission(permission: Permission): Int{
        return iPermission.insertPermission(permission)
    }

    /**
     * 更新权限信息
     * @return 是否成功
     */
    override fun updatePermission(permission: Permission): Int{
        return iPermission.updatePermission(permission)
    }

    /**
     * 根据条件获得权限
     * @return 权限列表
     */
    override fun selectPermission(permission: Permission):List<Permission>{
        return iPermission.selectPermission(permission)
    }

    /**
     * 删除权限
     * @return 是否成功
     */
    override fun deletePermission(id:Int):Int{
        return iPermission.deletePermission(id)
    }
}