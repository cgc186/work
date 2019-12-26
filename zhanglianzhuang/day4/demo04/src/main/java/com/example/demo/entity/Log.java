package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data //自动创建get和set方法
@TableName("mysyslog")
public class Log {
	@TableId(value = "id",type = IdType.AUTO)
	private int id;
	@TableField("username")
	private String username;
	@TableField("operation")
	private String operation;
	@TableField("time")
	private long time;
	@TableField("method")
	private String method;
	@TableField("params")
	private String params;
	@TableField("ip")
	private String ip;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createtime;

}
