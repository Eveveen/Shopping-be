package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Address;

@Repository
public interface AddressMapper {
	
	/**
	 * ��ѯ��ǰ�û����õ����е�ַ
	 * @param userId
	 * @return
	 */
	public List<Address> findAddressByUserId(Integer userId);
	
	/**
	 * ����addressId����ѯ��ַ
	 * @param addressId
	 * @return
	 */
	public Address findAddressByAddressId(Integer addressId);
	
	/**
	 * ��ѯĬ�ϵ�ַ
	 * @param userId
	 * @return
	 */
	public Address findDefaultAddressByUserId(Integer userId);
	
	/**
	 * ��ӵ�ַ
	 * @param address
	 * @return
	 */
	public int addAddress(Address address);
	
	/**
	 * ���¸��û���Ĭ�ϵ�ַ
	 * @param userId
	 * @return
	 */
	public int changeAddressStatus(Integer userId);
	
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
