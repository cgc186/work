package com.example.demo02.dao;
import com.example.demo02.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper

public interface IRole {
	int insertRole(Role role);
	List<Role> getRole(Role role);
	int updateRole(Role role);
	int deleteRole(Role role);
	int getRolebyname(Role role);
}
