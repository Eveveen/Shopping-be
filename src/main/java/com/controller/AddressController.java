package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Address;
import com.service.iface.AddressServiceIface;

@Controller
public class AddressController {
	
	@Autowired
	private AddressServiceIface addressService;
	
	/**
	 * ��ȡ��ǰ�û��µ����е�ַ
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getAllAddress")
	@ResponseBody
	public List<Address> findAllAddress(Integer userId){
		return addressService.findAddressByUserId(userId);
	}
	
	/**
	 * ��ӵ�ַ
	 * @param address
	 * @return
	 */
	@RequestMapping("/addAddress")
	@ResponseBody
	public int addAddress(Address address){
		return addressService.addAddress(address);
	}
	
	/**
	 * ���µ�ַ
	 * @param address
	 * @return
	 */
	@RequestMapping("/editAddress")
	@ResponseBody
	public int updateAddress(Address address){
		return addressService.updateAddress(address);
	}
	
	/**
	 * ɾ����ַ
	 * @param addressId
	 * @return
	 */
	@RequestMapping("/deleteAddress")
	@ResponseBody
	public int deleteAddress(Integer addressId){
		return addressService.deleteAddress(addressId);
	}

}
