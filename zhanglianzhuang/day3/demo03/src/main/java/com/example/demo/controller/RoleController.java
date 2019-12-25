package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserRoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 *说明：对角色表进行操作
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
@Api(tags = "Role")
@RestController
@EnableSwagger2
public class RoleController {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userroleMapper;
	@ApiOperation(value = "角色添加")
	@GetMapping("/addrole")
	public int addRole(Role role){
		List<Role> roles=getRolebyname(role);
		if(roles.size()==0){
			return roleMapper.insertRole(role);
		}
		else {
			System.out.println("角色名已存在！");
		}
		return 0;
	}
	@ApiOperation(value = "角色查询")
	@GetMapping("/getrole")
	public List<Role> selectRole(Role role){
		return roleMapper.getRole(role);
	}
	@ApiOperation(value = "角色更新")
	@PutMapping("/updaterole")
	public int updateRole(Role role){
		return roleMapper.updateRole(role);
	}
	@ApiOperation(value = "角色删除")
	@DeleteMapping("/deleterole")
	public int deleteRole(Role role){
		int flag=userroleMapper.getRolebyid(role);
		if (flag==0) {
			return roleMapper.deleteRoler(role);
		}
		else {
			System.out.println("该角色下还有用户!");
		}
		return 0;
	}

	public List<Role> getRolebyname(Role role){
		return roleMapper.getRolebyname(role);
	}

}
