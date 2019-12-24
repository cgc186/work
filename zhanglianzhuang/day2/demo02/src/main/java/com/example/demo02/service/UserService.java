package com.example.demo02.service;
import com.example.demo02.entity.User;

import java.util.List;

public interface UserService {
	int insertUser(User user);
	List<User> getUser(User user);
	int updateUser(User user);
	int deleteUser(User user);
}
