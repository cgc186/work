package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.mapper.UserRoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
@Api(tags = "UserRole")
@RestController
@EnableSwagger2
public class UserRoleController {
	@Autowired
	private UserRoleMapper userroleMapper;

	public int getRolebyid(Role role){
		return userroleMapper.getRolebyid(role);
	}
	@ApiOperation(value = "角色下用户查询")
	@GetMapping("/getsum")
	public List<String> getsum(Role role){
		return userroleMapper.getsum(role);
	}
}
