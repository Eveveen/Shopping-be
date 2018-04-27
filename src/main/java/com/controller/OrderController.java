package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Order;
import com.service.iface.OrderServiceIface;

@Controller
public class OrderController {
	
	@Autowired
	private OrderServiceIface orderService;
	
	@RequestMapping("/getAllOrder")
	@ResponseBody
	public List<Order> findOrderByUserId(Integer userId){
		return orderService.findOrderByUserId(userId);
	}
	
	@RequestMapping("/addOrder")
	@ResponseBody
	public int addOrder(Order order){
		return orderService.addOrder(order);
	}
	
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public int deleteOrder(Integer orderId){
		return orderService.deleteOrder(orderId);
	}


}
