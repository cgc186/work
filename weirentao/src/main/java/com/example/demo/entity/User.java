package com.example.demo.entity;
import java.util.Date;

/**
 * 说明：用户表实体
 * 编写人：wrt
 * 编写时间：12-2-8：54
 * 修改时间;
 */
public class User {
    private int id;

    private int appid;

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


    private String username;
    private String passwd;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
}
