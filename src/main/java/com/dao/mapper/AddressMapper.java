package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Address;

@Repository
public interface AddressMapper {
	
	/**
	 * 查询当前用户设置的所有地址
	 * @param userId
	 * @return
	 */
	public List<Address> findAddressByUserId(Integer userId);
	
	/**
	 * 根据addressId，查询地址
	 * @param addressId
	 * @return
	 */
	public Address findAddressByAddressId(Integer addressId);
	
	/**
	 * 查询默认地址
	 * @param userId
	 * @return
	 */
	public Address findDefaultAddressByUserId(Integer userId);
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public int addAddress(Address address);
	
	/**
	 * 更新该用户的默认地址
	 * @param userId
	 * @return
	 */
	public int changeAddressStatus(Integer userId);
	
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
