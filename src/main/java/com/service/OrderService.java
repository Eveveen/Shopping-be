package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.OrderMapper;
import com.dao.mapper.ProductMapper;
import com.entity.Order;
import com.entity.Product;
import com.service.iface.OrderServiceIface;
import com.service.iface.ProductServiceIface;

@Service
public class OrderService implements OrderServiceIface {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductServiceIface productService;

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

	@Override
	public int updateOrderCommentStatus(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderCommentStatus(order);
	}

	@Override
	public List<Order> searchOrder(Integer userId, String name) {
		// TODO Auto-generated method stub
		List<Order> searchOrderList = new ArrayList<Order>();
		List<Order> orderList = this.findOrderByUserId(userId);
		for(Order order : orderList){
			int proId = order.getProId();
			String proName = productMapper.findProductByProId(proId).getProName();
			order.setProName(proName);
		}
		
		List<Product> productList = productService.searchProduct(name);
		for(Order order : orderList) {
			for(Product product : productList) {
				if(order.getProName().equals(product.getProName())) {
					searchOrderList.add(order);
				}
			}
		}
		return searchOrderList;
	}

	@Override
	public List<Order> findOrderByUserIdAndStatus(Map map) {
		// TODO Auto-generated method stub
		return orderMapper.findOrderByUserIdAndStatus(map);
	}

	@Override
	public int updateCommentStatusByOrderNum(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateCommentStatusByOrderNum(order);
	}
}
