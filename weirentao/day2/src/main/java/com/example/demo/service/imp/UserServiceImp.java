package com.example.demo.service.imp;

import com.example.demo.dao.IUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private IUser iUser;

    @Override
    public int insertUser(User user){
        System.out.println(user.getAppid());
        return iUser.insertUser(user);
    }
    @Override
    public int updateUser(User user){
        return iUser.updateUser(user);
    }
    @Override
    public int deleteUser(int id){
        return iUser.deleteUser(id);
    }
    @Override
    public List<User>getAll(User user){
        return iUser.getAll();
    }

}
