package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *说明：对角色表进行操作
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
@Mapper
public interface UserRoleMapper {
	//通过rid查询该rid下用户数
	@Select("select count(*) from userrole where rid=#{rid}")
	public int getRolebyid(Role role);
	@Select("select rolename,count(*) from role join userrole on role.rid=userrole.rid")
	public List<String> getsum(Role role);
}
