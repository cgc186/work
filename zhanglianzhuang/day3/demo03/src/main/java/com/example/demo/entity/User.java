package com.example.demo.entity;

import java.util.Date;
/**
 *说明：用户实体
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
public class User {


	private int uid;
	private int appid;
	private String username;
	private String passwd;
	@org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createtime;

	public int getId() {
		return uid;
	}

	public void setId(int uid) {
		this.uid = uid;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}



}
