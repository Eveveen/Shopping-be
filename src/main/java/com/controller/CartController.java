package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public boolean addCart(Cart cart){
		if(cartService.addCart(cart) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("editCart")
	@ResponseBody
	public boolean updateCart(Cart cart){
		if(cartService.updateCart(cart) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据id删除单条购物车记录
	 * @param cartId
	 * @return
	 */
	@RequestMapping("deleteCart")
	@ResponseBody
	public boolean deleteCart(Integer cartId){
		if(cartService.deleteCart(cartId) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除多条购物车记录
	 * @param cartIds
	 * @return
	 */
	@RequestMapping("deleteCarts")
	@ResponseBody
	public boolean deleteCarts(String[] cartIds){
		if(cartService.deleteCartByIds(cartIds) != 0){
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("isCartExist")
	@ResponseBody
	public Cart findCartByProIdAndUserId(Integer proId, Integer userId){
		Map<String ,Integer> idMap = new HashMap<String ,Integer>();
		idMap.put("proId", proId);
		idMap.put("userId", userId);
		return cartService.findCartByProIdAndUserId(idMap);
	}
}
