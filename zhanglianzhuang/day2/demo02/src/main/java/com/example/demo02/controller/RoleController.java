package com.example.demo02.controller;

import com.example.demo02.entity.Role;
import com.example.demo02.entity.UserRole;
import com.example.demo02.service.RoleService;
import com.example.demo02.service.URService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Role")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private URService urService;
	@ApiOperation("添加角色信息")
	@PutMapping("/insertrole")
	public int addRole(Role role){
		int flag=roleService.getRolebyname(role);
		if(flag==0){
			return roleService.insertRole(role);
		}
		else{
			System.out.println("角色名已存在");
		}
		return 0;
	}
	@ApiOperation("查询角色")
	@GetMapping("/selectrole")
	public List<Role> selectRole(Role role){
		return roleService.getRole(role);
	}
	@ApiOperation("修改角色信息")
	@PutMapping("/updateRole")
	public int updateRole(Role role){
		return roleService.updateRole(role);
	}
	@ApiOperation("删除角色信息")
	@DeleteMapping("/deleteRole")
	public int deleteRole(Role role){
		int flag=urService.getRolebyid(role);
		if(flag==0) {
			return roleService.deleteRole(role);
		}
		else {
			System.out.println("该角色下存在用户！");
		}
		return 0;
	}

}
