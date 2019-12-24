package com.example.demo.dao;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IUser {
    //添加
    int insertUser(User user);
    //查询
    List<User> getAll();
    //删除
    int  deleteUser(int id);
    //修改
    int  updateUser(User user);

}
