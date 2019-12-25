package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *说明：对用户表进行操作
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */

@Mapper
public interface UserMapper {
	//插入用户信息
	@Insert("insert into user(uid,appid,username,passwd,createtime)values(#{uid},#{appid},#{username},#{passwd},#{createtime})")
	public int insertUser(User user);
	//指定用户名查询
	@Select("select uid,appid,username,passwd,createtime from user where username=#{username}")
	public List<User> getUserbyname(User user);
	//用户名模糊查询
	@Select("select uid,appid,username,passwd,createtime from user where username like CONCAT('%',#{username},'%')")
	public List<User> getUser(User user);
	//更新用户信息
	@Update("update user set appid=#{appid},username=#{username},passwd=#{passwd},createtime=#{createtime} where uid=#{uid}")
	public int updateUser(User user);
	//删除用户信息
	@Delete("delete from user where uid=#{uid} or username=#{username} or appid=#{appid}")
	public int deleteUser(User user);
}
