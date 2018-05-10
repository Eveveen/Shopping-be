package com.service.iface;

import java.util.List;
import java.util.Map;

import com.entity.Order;

public interface OrderServiceIface {
	
	/**
	 * 查询当前用户的所有订单
	 * @param userId
	 * @return
	 */
	public List<Order> findOrderByUserId(Integer userId);
	
	/**
	 * 新生成一个订单
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	 * 删除订单
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(Integer orderId);
	
	/**
	 * 更新评价状态
	 * @param order
	 * @return
	 */
	public int updateOrderCommentStatus(Order order);
	
	/**
	 * 根据商品名称查询订单
	 * @param name
	 * @return
	 */
	public List<Order> searchOrder(Integer userId, String name);
	
	/**
	 * 根据评价状态查询该用户的订单
	 * @param map
	 * @return
	 */
	public List<Order> findOrderByUserIdAndStatus(Map map);
}
