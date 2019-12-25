package com.example.demo02.service.imp;

import com.example.demo02.dao.IRole;
import com.example.demo02.entity.Role;
import com.example.demo02.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

	/*自动装载*/
	@Autowired
	private IRole iRole;
	@Override
	public int insertRole(Role role) {
		return iRole.insertRole(role);
	}

	@Override
	public List<Role> getRole(Role role) {
		return iRole.getRole(role);
	}

	@Override
	public int updateRole(Role role) {
		return iRole.updateRole(role);
	}

	@Override
	public int deleteRole(Role role) {
		return iRole.deleteRole(role);
	}

	@Override
	public int getRolebyname(Role role){
		return iRole.getRolebyname(role);
	}
}
