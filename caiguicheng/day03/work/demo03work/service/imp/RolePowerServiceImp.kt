package com.example.demo03work.service.imp

import com.example.demo03work.dao.IRolePower
import com.example.demo03work.entity.RolePower
import com.example.demo03work.service.RolePowerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class RolePowerServiceImp: RolePowerService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuserRolePower: IRolePower

    /**
     * 为角色添加权限
     * @return 是否成功
     */
    override fun insertRolePower(rolePower: RolePower): Int {
        return iuserRolePower.insertRolePower(rolePower)
    }

    /**
     * 更新角色权限信息
     * @return 是否成功
     */
    override fun updateRolePower(rolePower: RolePower): Int {
        return iuserRolePower.updateRolePower(rolePower)
    }

    /**
     * 根据条件获得角色权限
     * @return 权限列表
     */
    override fun selectRolePower(rolePower: RolePower): List<RolePower> {
        return iuserRolePower.selectRolePower(rolePower)
    }

    /**
     * 将角色的权限删除
     * @return 是否成功
     */
    override fun deleteRolePower(rolePower: RolePower): Int {
        return iuserRolePower.deleteRolePower(rolePower)
    }
}