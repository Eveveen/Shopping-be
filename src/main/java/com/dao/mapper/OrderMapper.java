package com.dao.mapper;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 根据订单编号更新评价状态
	 * @param order
	 * @return
	 */
	public int updateOrderCommentStatus(Order order);
	
	/**
	 * 根据评价状态查询该用户的订单
	 * @param map
	 * @return
	 */
	public List<Order> findOrderByUserIdAndStatus(Map map);
	
	/**
	 * 根据订单编号更新评价状态
	 * @param order
	 * @return
	 */
	public int updateCommentStatusByOrderNum(Order order);

}
