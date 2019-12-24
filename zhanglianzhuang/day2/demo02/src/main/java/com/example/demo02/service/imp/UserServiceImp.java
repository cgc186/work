package com.example.demo02.service.imp;

import com.example.demo02.dao.IUser;
import com.example.demo02.entity.User;
import com.example.demo02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
	/*自动装载*/
	@Autowired
	private IUser iUser;
	/*对方法进行重写*/
	@Override
	public int insertUser(User user) {
//		System.out.println(user.getCreatetime()+""+user.getAppid()+""+user.getId()+""+user.getPasswd()+""+user.getUsername());
		return iUser.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		return iUser.updateUser(user);
	}

	@Override
	public List<User> getUser(User user){
		return iUser.getUser(user);
	}

	@Override
	public int deleteUser(User user) {
		return iUser.deleteUser(user);
	}
}
