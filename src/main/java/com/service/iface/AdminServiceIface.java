package com.service.iface;

import com.entity.Admin;

public interface AdminServiceIface {
	
	/**
	 * ��֤����Ա��¼
	 * @param admin
	 * @return
	 */
	public Admin findAdminByNameAndPassword(Admin admin);

}
