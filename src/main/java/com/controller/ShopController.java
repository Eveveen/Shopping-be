package com.controller;

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
	
	@RequestMapping("/getShop")
	@ResponseBody
	public Shop findShop(Integer sellerId){
		return shopService.findShopBySellerId(sellerId);
	}
	
	@RequestMapping("/addShop")
	@ResponseBody
	public int addShop(Shop shop){
		return shopService.addShop(shop);
	}
	
	@RequestMapping("/editShop")
	@ResponseBody
	public int editShop(Shop shop){
		return shopService.updateShop(shop);
	}
	
	@RequestMapping("/deleteShop")
	@ResponseBody
	public int deleteShop(Integer shopId){
		return shopService.deleteShop(shopId);
	}


}
