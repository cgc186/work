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
	@Insert("insert into user(id,appid,username,passwd,createtime)values(#{id},#{appid},#{username},#{passwd},#{createtime})")
	public int insertUser(User user);
	@Select("select id,appid,username,passwd,createtime from user")
	public List<User> getUser(User user);
	@Update("update user set appid=#{appid},username=#{username},passwd=#{passwd},createtime=#{createtime} where id=#{id}")
	public int updateUser(User user);
	@Delete("delete from user where id=#{id} or username=#{username} or appid=#{appid}")
	public int deleteUser(User user);
}
