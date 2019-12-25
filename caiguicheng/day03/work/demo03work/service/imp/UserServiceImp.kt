package com.example.demo03work.service.imp

import com.example.demo03work.dao.IUser
import com.example.demo03work.entity.User
import com.example.demo03work.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class UserServiceImp:UserService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuser: IUser

    /**
     * 插入用户
     * @return 是否成功
     */
    override fun insertUser(user: User): Int {
        return iuser.insertUser(user)
    }

    /**
     * 更新用户信息
     * @return 是否成功
     */
    override fun updateUser(user: User): Int {
        return iuser.updateUser(user)
    }

    /**
     * 根据条件获得用户
     * @return 用户列表
     */
    override fun selectUser(user: User): List<User> {
        println(user.id)
        return iuser.selectUser(user)
    }

    /**
     * 删除用户
     * @return 是否成功
     */
    override fun deleteUser(id: Int): Int {
        return iuser.deleteUser(id)
    }
}