package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Cart;
import com.service.iface.CartServiceIface;

@Controller
public class CartController {
	
	@Autowired
	private CartServiceIface cartService;
	
	@RequestMapping("getAllCart")
	@ResponseBody
	public List<Cart> findCartByUserId(Integer userId){
		return cartService.findCartByUserId(userId);
	}
	
	@RequestMapping("addCart")
	@ResponseBody
	public int addCart(Cart cart){
		return cartService.addCart(cart);
	}
	
	@RequestMapping("editCart")
	@ResponseBody
	public int updateCart(Cart cart){
		return cartService.updateCart(cart);
	}
	
	@RequestMapping("deleteCart")
	@ResponseBody
	public int deleteCart(Integer cartId){
		return cartService.deleteCart(cartId);
	}
	

}
