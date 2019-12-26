package com.example.demo04.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import lombok.Data
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

//@Data
@TableName("mysyslog")
class Log {
    @TableId(value = "id", type = IdType.AUTO)
    var id: Int = 0
    @TableField("username")
    var username: String = ""
    @TableField("operation")
    var operation: String = ""
    @TableField("time")
    var time: Long = 0L
    @TableField("method")
    var method: String = ""
    @TableField("params")
    var params: String = ""
    @TableField("ip")
    var ip: String = ""
    @TableField("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var createTime: Date? = null
}

//@TableName("mysyslog")
//data class T(
//        @TableId(value = "id", type = IdType.AUTO)
//        var id: Int = 0,
//        @TableField("username")
//        var username: String = "",
//        @TableField("operation")
//        var operation: String = "",
//        @TableField("time")
//        var time: Long = 0L,
//        @TableField("method")
//        var method: String = "",
//        @TableField("parms")
//        var parms: String = "",
//        @TableField("ip")
//        var ip: String = "",
//        @TableField("createTime")
//        @DateTimeFormat(pattern = "yyyy-MM-dd")
//        var createTime: Date? = null
//)