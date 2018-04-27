package com.service.iface;

import java.util.List;

import com.entity.Address;

public interface AddressServiceIface {
	
	/**
	 * 查询当前用户设置的所有地址
	 * @param userId
	 * @return
	 */
	public List<Address> findAddressByUserId(Integer userId);
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public int addAddress(Address address);
	
	/**
	 * 更新地址
	 * @param address
	 * @return
	 */
	public int updateAddress(Address address);
	
	/**
	 * 删除地址
	 * @param addressId
	 * @return
	 */
	public int deleteAddress(Integer addressId);

}
