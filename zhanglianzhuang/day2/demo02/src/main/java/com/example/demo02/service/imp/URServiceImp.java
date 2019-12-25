package com.example.demo02.service.imp;


import com.example.demo02.dao.IUserRole;
import com.example.demo02.entity.Role;
import com.example.demo02.service.URService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URServiceImp implements URService {

	@Autowired
	private IUserRole iUserRole;

	@Override
	public int getRolebyid(Role role) {
		return iUserRole.getRolebyid(role);
	}
}
