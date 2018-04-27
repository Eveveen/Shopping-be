package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Order;

@Repository
public interface OrderMapper {
	
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

}
