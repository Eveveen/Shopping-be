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
	public boolean addOrder(Order order){
		if(orderService.addOrder(order) == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public boolean deleteOrder(Integer orderId){
		if(orderService.deleteOrder(orderId) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ¸üÐÂÆÀ¼Û×´Ì¬
	 * @param order
	 * @return
	 */
	@RequestMapping("/editOrderCommentStatus")
	@ResponseBody
	public boolean updateOrderCommentStatus(Order order){
		if(orderService.updateOrderCommentStatus(order) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	


}
