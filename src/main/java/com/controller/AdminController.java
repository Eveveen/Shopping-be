package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Admin;
import com.service.iface.AdminServiceIface;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceIface adminService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Admin findAdminByNameAndPassword(Admin admin){
		return adminService.findAdminByNameAndPassword(admin);
	}

}
