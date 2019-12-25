package com.example.demo.mapper;
import com.example.demo.entity.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 说明：对用户表进行操作
 * wrt
 * 编写时间：12-25
 * 修改时间：
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(id,appid,username,passwd,createtime)values(#{id},#{appid},#{username},#{passwd},#{createtime})")
     int insertUser(User user);
    @Update("update user set appid=#{appid},username=#{username},passwd=#{passwd},createtime=#{createtime}where id = #{id}")
    int  updateUser(User user);
    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);
    @Select("select * from user")
    List<User> selectAllUsers();
}
