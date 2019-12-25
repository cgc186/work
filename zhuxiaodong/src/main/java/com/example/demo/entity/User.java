package com.example.demo.entity;

import java.util.Date;
/**
 * 说明：
 * 编写人：zhu
 * 编写时间：2019-12-25
 * 修改时间：
 */
public class User {

    private int id;
    private int appid;
    private String username;
    private String passwd;
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
