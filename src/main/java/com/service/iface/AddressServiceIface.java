package com.service.iface;

import java.util.List;

import com.entity.Address;

public interface AddressServiceIface {
	
	/**
	 * ��ѯ��ǰ�û����õ����е�ַ
	 * @param userId
	 * @return
	 */
	public List<Address> findAddressByUserId(Integer userId);
	
	/**
	 * ��ӵ�ַ
	 * @param address
	 * @return
	 */
	public int addAddress(Address address);
	
	/**
	 * ���µ�ַ
	 * @param address
	 * @return
	 */
	public int updateAddress(Address address);
	
	/**
	 * ɾ����ַ
	 * @param addressId
	 * @return
	 */
	public int deleteAddress(Integer addressId);

}
