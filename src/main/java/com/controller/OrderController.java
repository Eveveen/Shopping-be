package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 更新评价状态
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
	
	/**
	 * 根据关键字搜索订单
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchOrder")
	@ResponseBody
	public List<Order> searchOrder(Integer userId, String proName){
		return orderService.searchOrder(userId, proName);
	}
	
	/**
	 * 根据评价状态查询该用户的订单
	 * @param userId
	 * @param commentStatus
	 * @return
	 */
	@RequestMapping("/getOrderByStatus")
	@ResponseBody
	public List<Order> findOrderByUserIdAndStatus(Integer userId, Integer commentStatus){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", userId);
		map.put("commentStatus", commentStatus);
		return orderService.findOrderByUserIdAndStatus(map);
	}
}
