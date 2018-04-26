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
	 * 获取当前用户下的所有地址
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getAllAddress")
	@ResponseBody
	public List<Address> findAllAddress(Integer userId){
		return addressService.findAddressByUserId(userId);
	}
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/addAddress")
	@ResponseBody
	public int addAddress(Address address){
		return addressService.addAddress(address);
	}
	
	/**
	 * 更新地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/editAddress")
	@ResponseBody
	public int updateAddress(Address address){
		return addressService.updateAddress(address);
	}
	
	/**
	 * 删除地址
	 * @param addressId
	 * @return
	 */
	@RequestMapping("/deleteAddress")
	@ResponseBody
	public int deleteAddress(Integer addressId){
		return addressService.deleteAddress(addressId);
	}

}
