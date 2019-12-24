package com.example.demo02.dao;
import com.example.demo02.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface IUser {
	int insertUser(User user);
	List<User> getUser(User user);
	int updateUser(User user);
	int deleteUser(User user);
}
