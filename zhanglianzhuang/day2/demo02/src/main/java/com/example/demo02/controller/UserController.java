package com.example.demo02.controller;

import com.example.demo02.entity.User;
import com.example.demo02.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation("添加用户信息")
	@PutMapping("/addUser")
	public int AddUser(User user){
		return userService.insertUser(user);
	}

	@ApiOperation("查询所有的数据")
	@GetMapping("/getUser")
	public List<User> getUser(User user){
		return userService.getUser(user);
	}

	@ApiOperation("更新用户信息")
	@PutMapping("/updateUser")
	public int updateUser(User user){
		return userService.updateUser(user);
	}

	@ApiOperation("删除用户数据")
	@DeleteMapping("/deleteUser")
	public int deleteUser(User user){
		return userService.deleteUser(user);
	}
}
