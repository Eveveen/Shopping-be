package com.dao.mapper;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * ���ݶ�����Ÿ�������״̬
	 * @param order
	 * @return
	 */
	public int updateOrderCommentStatus(Order order);
	
	/**
	 * ��������״̬��ѯ���û��Ķ���
	 * @param map
	 * @return
	 */
	public List<Order> findOrderByUserIdAndStatus(Map map);
	
	/**
	 * ���ݶ�����Ÿ�������״̬
	 * @param order
	 * @return
	 */
	public int updateCommentStatusByOrderNum(Order order);

}
