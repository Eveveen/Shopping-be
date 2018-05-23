package com.service.iface;

import com.entity.Admin;

public interface AdminServiceIface {
	
	/**
	 * 验证管理员登录
	 * @param admin
	 * @return
	 */
	public Admin findAdminByNameAndPassword(Admin admin);

}
