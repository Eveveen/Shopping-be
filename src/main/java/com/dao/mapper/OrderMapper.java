package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Order;

@Repository
public interface OrderMapper {
	
	/**
	 * ��ѯ��ǰ�û������ж���
	 * @param userId
	 * @return
	 */
	public List<Order> findOrderByUserId(Integer userId);
	
	/**
	 * ������һ������
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	 * ɾ������
	 * @param orderId
	 * @return
	 */
	public int deleteOrder(Integer orderId);

}
