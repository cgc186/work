package com.example.demo03work.service.imp

import com.example.demo03work.dao.IPower
import com.example.demo03work.entity.Power
import com.example.demo03work.service.PowerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class PowerServiceImp : PowerService {
    //使用时候创建
    @Autowired
    @Lazy
    lateinit var ipower: IPower

    /**
     * 插入权限
     * @return 是否成功
     */
    override fun insertPower(power: Power): Int{
        return ipower.insertPower(power)
    }

    /**
     * 更新权限信息
     * @return 是否成功
     */
    override fun updatePower(power: Power): Int{
        return ipower.updatePower(power)
    }

    /**
     * 根据条件获得权限
     * @return 权限列表
     */
    override fun selectPower(power: Power):List<Power>{
        return ipower.selectPower(power)
    }

    /**
     * 删除权限
     * @return 是否成功
     */
    override fun deletePower(id:Int):Int{
        return ipower.deletePower(id)
    }
}