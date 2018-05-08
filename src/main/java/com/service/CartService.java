package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.CartMapper;
import com.entity.Cart;
import com.entity.Product;
import com.service.iface.CartServiceIface;

@Service
public class CartService implements CartServiceIface {
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> findCartByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return cartMapper.findCartByUserId(userId);
	}

	@Override
	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.addCart(cart);
	}

	@Override
	public int updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.updateCart(cart);
	}

	@Override
	public int deleteCart(Integer cartId) {
		// TODO Auto-generated method stub
		return cartMapper.deleteCart(cartId);
	}

	@Override
	public int deleteCartByIds(String[] cartIds) {
		// TODO Auto-generated method stub
		return cartMapper.deleteCartByIds(cartIds);
	}

	@Override
	public Cart findCartByProIdAndUserId(Map idMap) {
		// TODO Auto-generated method stub
		return cartMapper.findCartByProIdAndUserId(idMap);
	}

}
