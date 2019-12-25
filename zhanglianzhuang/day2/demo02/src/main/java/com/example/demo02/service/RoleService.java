package com.example.demo02.service;

import com.example.demo02.entity.Role;

import java.util.List;

public interface RoleService {
	int insertRole(Role role);
	List<Role> getRole(Role role);
	int updateRole(Role role);
	int deleteRole(Role role);
	int getRolebyname(Role role);
}
