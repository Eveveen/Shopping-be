package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.AddressMapper;
import com.entity.Address;
import com.service.iface.AddressServiceIface;

@Service
public class AddressService implements AddressServiceIface {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public List<Address> findAddressByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return addressMapper.findAddressByUserId(userId);
	}

	@Override
	public Address findAddressByAddressId(Integer addressId) {
		// TODO Auto-generated method stub
		return addressMapper.findAddressByAddressId(addressId);
	}

	@Override
	public Address findDefaultAddressByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return addressMapper.findDefaultAddressByUserId(userId);
	}

	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.addAddress(address);
	}

	@Override
	public int changeAddressStatus(Integer userId) {
		// TODO Auto-generated method stub
		return addressMapper.changeAddressStatus(userId);
	}

	@Override
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		return addressMapper.updateAddress(address);
	}

	@Override
	public int deleteAddress(Integer addressId) {
		// TODO Auto-generated method stub
		return addressMapper.deleteAddress(addressId);
	}
}
