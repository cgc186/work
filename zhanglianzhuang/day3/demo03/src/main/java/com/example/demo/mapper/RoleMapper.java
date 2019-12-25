package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *说明：对角色表进行操作
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
@Mapper
public interface RoleMapper {
	//插入角色信息
	@Insert("insert into role(rid,rolename,remarks)values(#{rid},#{rolename},#{remarks})")
	public int insertRole(Role role);
	//通过指定角色名查询
	@Select("select rid,rolename,remarks from role where rolename =#{rolename}")
	public List<Role> getRolebyname(Role role);
	//通过角色名模糊查询
	@Select("select rid,rolename,remarks from role where rolename like CONCAT('%',#{rolename},'%')")
	public List<Role> getRole(Role role);

	//更新角色信息
	@Update("update role set rolename=#{rolename},remarks=#{remarks} where rid=#{rid}")
	public int updateRole(Role role);
	//删除角色信息
	@Delete("delete from role where rid=#{rid} or rolename=#{rolename}")
	public int deleteRoler(Role role);
}
