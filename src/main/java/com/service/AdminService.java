package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.AdminMapper;
import com.entity.Admin;
import com.service.iface.AdminServiceIface;

@Service
public class AdminService implements AdminServiceIface {
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin findAdminByNameAndPassword(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminByNameAndPassword(admin);
	}

}
