package com.example.demo03work.service.imp

import com.example.demo03work.dao.IRole
import com.example.demo03work.entity.Role
import com.example.demo03work.entity.User
import com.example.demo03work.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class RoleServiceImp:RoleService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var irole: IRole

    /**
     * 插入角色
     * @return 是否成功
     */
    override fun insertRole(role: Role): Int{
        return irole.insertRole(role)
    }

    /**
     * 更新角色信息
     * @return 是否成功
     */
    override fun updateRole(role: Role): Int{
        return irole.updateRole(role)
    }

    /**
     * 根据条件获得角色
     * @return 用户列表
     */
    override fun selectRole(role: Role):List<Role>{
        return irole.selectRole(role)
    }

    /**
     * 删除角色
     * @return 是否成功
     */
    override fun deleteRole(id:Int):Int{
        return irole.deleteRole(id)
    }
}