package com.example.demo03work.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
/**
 * 说明: 日志表实体
 * 编写人: 蔡
 * 编写时间: 2019-12-26
 * 修改时间:
 * 记录用户基本信息
 * @property id id
 * @property username 用户名
 * @property operation 操作
 * @property time 时间
 * @property method 使用方法
 * @property params
 * @property ip
 * @property createTime 创建时间
 * @constructor 创建一个学生对象
 */
//@Data
@TableName("mysyslog")
data class Log(
        @TableId(value = "id", type = IdType.AUTO)
        var id: Int = 0,
        @TableField("username")
        var username: String = "",
        @TableField("operation")
        var operation: String = "",
        @TableField("time")
        var time: Long = 0L,
        @TableField("method")
        var method: String = "",
        @TableField("params")
        var params: String = "",
        @TableField("ip")
        var ip: String = "",
        @TableField("createTime")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        var createTime: Date? = null
)