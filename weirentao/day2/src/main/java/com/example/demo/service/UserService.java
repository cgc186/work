package com.example.demo.service;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    //添加
    int insertUser(User user);
    //查询
    List<User> getAll();
    //删除
    int  deleteUser(int id);
    //修改
    int  updateUser(User user);
}
