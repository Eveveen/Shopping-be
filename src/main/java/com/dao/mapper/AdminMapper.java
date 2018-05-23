package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Admin;

@Repository
public interface AdminMapper {
	
	/**
	 * 验证管理员登录
	 * @param admin
	 * @return
	 */
	public Admin findAdminByNameAndPassword(Admin admin);

}
