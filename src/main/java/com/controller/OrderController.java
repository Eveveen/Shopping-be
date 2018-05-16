package com.controller;

import java.util.Date;
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
	
	@RequestMapping("/getShopOrder")
	@ResponseBody
	public List<Order> findOrderByShopId(Integer shopId){
		return orderService.findOrderByShopId(shopId);
	}
	
	@RequestMapping("/addOrder")
	@ResponseBody
	public boolean addOrder(Order order){
		System.out.println("adddate,," + new Date());
		order.setCreateTime(new Date());
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
		List<Order> orderList = orderService.findOrderByOrderNum(order.getOrderNum());
		for(Order o : orderList){
			order.setPayTime(o.getPayTime());
			order.setDealTime(o.getDealTime());
			order.setDeliverTime(o.getDeliverTime());
		}
		if(order.getCommentStatus() == 0){ //已确认收收货，待评价
			order.setDealTime(new Date());
		} else if(order.getCommentStatus() == 3){ // 已付款，待发货			
			order.setPayTime(new Date());
		} else if(order.getCommentStatus() == 4){ // 已发货，待收货
			order.setDeliverTime(new Date());
		}
		if(order.getOrderId() == null) { // 根据订单编号更新状态
			if(orderService.updateCommentStatusByOrderNum(order) == 1) {
				return true;
			} else {
				return false;
			}
		} else { // 根据订单Id更新状态
			if(orderService.updateOrderCommentStatus(order) == 1) {
				return true;
			} else {
				return false;
			}
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
	
	/**
	 * 根据评价状态查询该店铺的订单
	 * @param userId
	 * @param commentStatus
	 * @return
	 */
	@RequestMapping("/getOrderByShopIdAndStatus")
	@ResponseBody
	public List<Order> findOrderByShopIdAndStatus(Integer shopId, Integer commentStatus){
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("shopId", shopId);
		map.put("commentStatus", commentStatus);
		return orderService.findOrderByShopIdAndStatus(map);
	}
	
	/**
	 * 根据商品id查询订单，用于查询已售出多少件商品
	 * @param proId
	 * @return
	 */
	@RequestMapping("/getOrderByProId")
	@ResponseBody
	public List<Order> findOrderByProId(Integer proId){
		return orderService.findOrderByProId(proId);
	}
}
