package com.example.demo03work.service.imp

import com.example.demo03work.dao.IUserRole
import com.example.demo03work.entity.UserRole
import com.example.demo03work.service.UserRoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class UserRoleServiceImp : UserRoleService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuserRole: IUserRole

    /**
     * 为用户添加角色
     * @return 是否成功
     */
    override fun insertUserRole(userRole: UserRole): Int {
        return iuserRole.insertUserRole(userRole)
    }

    /**
     * 更新用户角色信息
     * @return 是否成功
     */
    override fun updateUserRole(userRole: UserRole): Int {
        return iuserRole.updateUserRole(userRole)
    }

    /**
     * 根据条件获得用户角色表
     * @return 用户角色列表
     */
    override fun selectUserRole(userRole: UserRole): List<UserRole> {
        return iuserRole.selectUserRole(userRole)
    }

    /**
     * 删除用户的某个角色
     * @return 是否成功
     */
    override fun deleteUserRole(userRole: UserRole): Int {
        return iuserRole.deleteUserRole(userRole)
    }
}