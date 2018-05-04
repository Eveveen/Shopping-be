package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.OrderMapper;
import com.entity.Order;
import com.service.iface.OrderServiceIface;

@Service
public class OrderService implements OrderServiceIface {
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<Order> findOrderByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderMapper.findOrderByUserId(userId);
	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.addOrder(order);
	}

	@Override
	public int deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		return orderMapper.deleteOrder(orderId);
	}

}
