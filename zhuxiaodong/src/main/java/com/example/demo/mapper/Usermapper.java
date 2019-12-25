package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 说明：对用户表进行操作
 * 编写人：zhu
 * 编写时间：2019-12-25
 * 修改时间：
 */
@Mapper
public interface Usermapper {

    @Insert("insert into user" +
            "(id, appid, username, passwd, createtime)" +
            "VALUES (\n" +
            "#{id,jdbcType= INTEGER},\n" +
            "#{appid,jdbcType=INTEGER},\n" +
            "#{username,jdbcType=VARCHAR},\n" +
            "#{passwd,jdbcType=VARCHAR},\n" +
            "#{createtime,jdbcType=TIMESTAMP} )")
    public int insertUser(User user);

    @Select("select id,appid,username,passwd,createtime from user where username=#{username}")
    public List<User>getAll(String username);
}
