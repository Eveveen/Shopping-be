package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Admin;

@Repository
public interface AdminMapper {
	
	/**
	 * ��֤����Ա��¼
	 * @param admin
	 * @return
	 */
	public Admin findAdminByNameAndPassword(Admin admin);

}
