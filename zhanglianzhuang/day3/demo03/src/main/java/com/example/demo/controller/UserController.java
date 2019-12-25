package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
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
 *说明：对用户表进行操作
 * 编写人：张连壮
 * 编写时间：2019年12月25日
 * 修改时间
 */
@Api(tags = "User")
@RestController
@EnableSwagger2
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@ApiOperation(value = "用户添加")
	@GetMapping("/addUser")
	public int AddUser(User user){
		List<User>users=getUserbyname(user);
		if (users.size()==0) {
			if (user != null) {
				if (user.getId() != 0) {
					return userMapper.insertUser(user);
				} else {
					System.out.println("用户id不能为空!");
				}
			}
		}
		else {
			System.out.println("用户名已存在");
		}
		return 0;
	}

	@ApiOperation("查询所有的数据")
	@GetMapping("/getUser")
	public List<User> getUser(User user){
		return userMapper.getUser(user);
	}

	@ApiOperation("更新用户信息")
	@PutMapping("/updateUser")
	public int updateUser(User user){
		if (user!=null){
			if(user.getId()!=0){
				return userMapper.insertUser(user);
			}
			else {
				System.out.println("用户id不能为空!");
			}
		}
		return 0;
	}

	@ApiOperation("删除用户数据")
	@DeleteMapping("/deleteUser")
	public int deleteUser(User user){
		if (user!=null){
			if(user.getId()!=0){
				return userMapper.insertUser(user);
			}
			else {
				System.out.println("用户id不能为空!");
			}
		}
		return 0;
	}
	public List<User> getUserbyname(User user){
		return userMapper.getUserbyname(user);
	}
}
