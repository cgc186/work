package com.example.demo03work.dao

import com.example.demo03work.entity.Power
import org.apache.ibatis.annotations.Mapper

/**
 * 权限操作接口类
 */
@Mapper
interface IPower {
    /**
     * 插入权限
     * @return 是否成功
     */
    fun insertPower(power: Power): Int

    /**
     * 更新权限信息
     * @return 是否成功
     */
    fun updatePower(power: Power): Int

    /**
     * 根据条件获得权限
     * @return 权限列表
     */
    fun selectPower(power: Power):List<Power>

    /**
     * 删除权限
     * @return 是否成功
     */
    fun deletePower(id:Int):Int
}