package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/getAddress")
	@ResponseBody
	public Address findAddressByAddressId(Integer addressId){
		return addressService.findAddressByAddressId(addressId);
	}
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/addAddress")
	@ResponseBody
	public boolean addAddress(Address address) throws UnsupportedEncodingException{
//		System.out.println(new String(address.getAddressName().getBytes("iso8859-1"),"utf-8"));
		System.out.println(address.getAddressName());
		if(addressService.addAddress(address) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param address
	 * @return
	 */
	@RequestMapping("/changeAddressStatus")
	@ResponseBody
	public boolean changeAddressStatus(Integer userId){
		if(addressService.changeAddressStatus(userId) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 更新地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/editAddress")
	@ResponseBody
	public boolean updateAddress(Address address){
		if(addressService.updateAddress(address) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除地址
	 * @param addressId
	 * @return
	 */
	@RequestMapping("/deleteAddress")
	@ResponseBody
	public boolean deleteAddress(Integer addressId){
		if(addressService.deleteAddress(addressId) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
