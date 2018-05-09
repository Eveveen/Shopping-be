package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Seller;
import com.entity.User;
import com.service.iface.SellerServiceIface;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerServiceIface sellerService;
	
	/**
	 * 根据用户名和密码判断是否登录成功
	 * @param seller
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Seller Login(Seller seller) {

		String name = seller.getSellerName();
		String password = seller.getPassword();
		
		Seller s = new Seller();
		s.setSellerName(name);
		s.setPassword(password);

		if (sellerService.findSellerByNameAndPassword(s) != null) {
			return sellerService.findSellerByNameAndPassword(s);
		} else {
			return null;
		}
	}
	
	/**
	 * 获取所有的卖家
	 * @return
	 */
	@RequestMapping("/getAllSeller")
	@ResponseBody
	public List<Seller> getAllSeller(){
		return sellerService.findAllSeller();
	}
	
	/**
	 * 添加卖家
	 * @param seller
	 * @return
	 */
	@RequestMapping("/addSeller")
	@ResponseBody
	public boolean addSeller(Seller seller){
		if(sellerService.addSeller(seller) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 更新卖家
	 * @param seller
	 * @return
	 */
	@RequestMapping("/editSeller")
	@ResponseBody
	public boolean editSeller(Seller seller){
		if(sellerService.updateSellerById(seller) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除卖家
	 * @param sellerId
	 * @return
	 */
	@RequestMapping("/deleteSeller")
	@ResponseBody
	public boolean deleteSeller(Integer sellerId){
		if(sellerService.deleteSeller(sellerId) == 1){
			return true;			
		} else {
			return false;
		}
	}
	
	/**
	 * 根据卖家编号查询卖家信息
	 * @param sellerId
	 * @return
	 */
	@RequestMapping("/getSeller")
	@ResponseBody
	public Seller findSellerBySellerId(Integer sellerId) {
		return sellerService.findSellerBySellerId(sellerId);
	}

}
