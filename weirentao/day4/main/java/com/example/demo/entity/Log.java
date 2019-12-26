package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Data
@TableName("mysyslog")
public class Log {
    @TableId(value="id",type = IdType.AUTO)
    private int id;
    @TableField("username")
    private String username;
    @TableField("operation")
    private String operation;
    @TableField("time")
    private long time;
    @TableField("hethod")
    private String hethod;
    @TableField("parms")
    private String parms;
    @TableField("ip")
    private String ip;
    @TableField("createtime")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

}
