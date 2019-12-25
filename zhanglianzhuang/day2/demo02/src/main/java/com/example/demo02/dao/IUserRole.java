package com.example.demo02.dao;

import com.example.demo02.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRole {
	public int getRolebyid(Role role);
}
