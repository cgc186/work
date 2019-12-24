package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;


public interface UserService {
    int insertUser(User user);

    List<User>getAll(User user);
}
