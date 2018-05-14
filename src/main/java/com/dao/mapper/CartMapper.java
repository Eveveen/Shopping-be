package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Cart;

@Repository
public interface CartMapper {
	
	/**
	 * 查询当前用户的购物车
	 * @param userId
	 * @return
	 */
	public List<Cart> findCartByUserId(Integer userId);
	
	/**
	 * 向购物车添加1条记录
	 * @param cart
	 * @return
	 */
	public int addCart(Cart cart);
	
	/**
	 * 编辑购物车
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart);
	
	/**
	 * 删除购物车中的1条记录
	 * @param cartId
	 * @return
	 */
	public int deleteCart(Integer cartId);
	
	/**
	 * 一次删除多条记录
	 * @param cartIds
	 * @return
	 */
	public int deleteCartByIds(String[] cartIds);
	
	/**
	 * 根据商品编号和用户编号查询购物车信息
	 * @param idMap
	 * @return
	 */
	public Cart findCartByProIdAndUserId(Map idMap);

}
