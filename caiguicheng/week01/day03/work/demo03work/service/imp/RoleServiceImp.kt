package com.example.demo03work.service.imp

import com.example.demo03work.dao.IRole
import com.example.demo03work.dao.IRolePower
import com.example.demo03work.dao.IUserRole
import com.example.demo03work.entity.Role
import com.example.demo03work.entity.RoleNum
import com.example.demo03work.entity.UserRole
import com.example.demo03work.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class RoleServiceImp : RoleService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var irole: IRole

    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuserRole: IUserRole

    /**
     * 插入角色
     * 插入前进行搜索 是否有同名
     * @return 是否成功
     */
    override fun insertRole(role: Role): Int {
        val r = Role()
        r.rolename = role.rolename
        if (irole.selectRole(r).isEmpty()) {
            return irole.insertRole(role)
        }
        return 0
    }

    /**
     * 更新角色信息
     * @return 是否成功
     */
    override fun updateRole(role: Role): Int {
        return irole.updateRole(role)
    }

    /**
     * 根据条件获得角色
     * @return 用户列表
     */
    override fun selectRole(role: Role): List<Role> {
        return irole.selectRole(role)
    }

    /**
     * 显示列表
     * @return 角色列表
     */
    override fun getRoleNumber(): List<RoleNum> {
        return irole.getRoleNumber()
    }

    /**
     * 删除角色
     * @return 是否成功
     */
    override fun deleteRole(id: Int): Int {
        //先查询在用户角色表中是否有用户使用该角色
        //有使用则不删除
        val ur = UserRole()
        ur.rid = id
        if (iuserRole.selectUserRole(ur).isEmpty()) {
            return irole.deleteRole(id)
        }
        return 0
    }
}