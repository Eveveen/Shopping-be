package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Shop;
import com.service.iface.ShopServiceIface;

@Controller
public class ShopController {
	
	@Autowired
	private ShopServiceIface shopService;
	
	@RequestMapping("/getSellerShop")
	@ResponseBody
	public Shop findSellerShop(Integer sellerId){
		return shopService.findShopBySellerId(sellerId);
	}
	
	@RequestMapping("/getShop")
	@ResponseBody
	public Shop findShopByShopId(Integer shopId){
		return shopService.findShopByShopId(shopId);
	}
	
	@RequestMapping("/getAllShop")
	@ResponseBody
	public List<Shop> findAllShop(){
		return shopService.findAllShop();
	}
	
	@RequestMapping("/addShop")
	@ResponseBody
	public boolean addShop(Shop shop){
		if(shopService.addShop(shop) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	@RequestMapping("/editShop")
	@ResponseBody
	public boolean editShop(Shop shop){
		if(shopService.updateShop(shop) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	@RequestMapping("/deleteShop")
	@ResponseBody
	public boolean deleteShop(Integer shopId){
		if(shopService.deleteShop(shopId) == 1) {
			return true;
		} else {			
			return false;
		}
	}


}
