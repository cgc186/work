package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUser {

    int insertUser(User user);

    List<User> getAll(User user);
}

