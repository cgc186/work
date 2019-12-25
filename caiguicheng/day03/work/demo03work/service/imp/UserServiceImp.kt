package com.example.demo03work.service.imp

import com.example.demo03work.dao.IUser
import com.example.demo03work.entity.Order
import com.example.demo03work.entity.User
import com.example.demo03work.entity.UserData
import com.example.demo03work.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImp:UserService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var iuser: IUser


    /**
     * 插入用户
     * 插入前进行搜索 是否有同名
     * @return 是否成功
     */
    override fun insertUser(user: User): Int {
        //先查询是否有同名
        //没有则插入
        val u = User()
        u.username = user.username
        if (iuser.selectUser(u).isEmpty()){
            return iuser.insertUser(user)
        }
        return 0
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
     * 姓名模糊查询
     * @return 用户列表
     */
    override fun selectUserByName(name: String): List<User>{
        return iuser.selectUserByName(name)
    }

    /**
     * 时间区间查询
     * @return 用户列表
     */
    override fun selectUserByTime(time: Order): List<User>{
        return iuser.selectUserByTime(time)
    }

    /**
     * 显示列表
     * @return 用户列表
     */
    override fun getUserList(): List<UserData>{
        return iuser.getUserList()
    }

    /**
     * 删除用户
     * @return 是否成功
     */
    override fun deleteUser(id: Int): Int {
        return iuser.deleteUser(id)
    }
}