package com.service.iface;

import java.util.List;
import java.util.Map;

import com.entity.Order;

public interface OrderServiceIface {
	
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
	
	/**
	 * ��������״̬
	 * @param order
	 * @return
	 */
	public int updateOrderCommentStatus(Order order);
	
	/**
	 * ������Ʒ���Ʋ�ѯ����
	 * @param name
	 * @return
	 */
	public List<Order> searchOrder(Integer userId, String name);
	
	/**
	 * ��������״̬��ѯ���û��Ķ���
	 * @param map
	 * @return
	 */
	public List<Order> findOrderByUserIdAndStatus(Map map);
}
