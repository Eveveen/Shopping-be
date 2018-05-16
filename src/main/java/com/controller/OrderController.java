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
	 * ��������״̬
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
		if(order.getCommentStatus() == 0){ //��ȷ�����ջ���������
			order.setDealTime(new Date());
		} else if(order.getCommentStatus() == 3){ // �Ѹ��������			
			order.setPayTime(new Date());
		} else if(order.getCommentStatus() == 4){ // �ѷ��������ջ�
			order.setDeliverTime(new Date());
		}
		if(order.getOrderId() == null) { // ���ݶ�����Ÿ���״̬
			if(orderService.updateCommentStatusByOrderNum(order) == 1) {
				return true;
			} else {
				return false;
			}
		} else { // ���ݶ���Id����״̬
			if(orderService.updateOrderCommentStatus(order) == 1) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	/**
	 * ���ݹؼ�����������
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchOrder")
	@ResponseBody
	public List<Order> searchOrder(Integer userId, String proName){
		return orderService.searchOrder(userId, proName);
	}
	
	/**
	 * ��������״̬��ѯ���û��Ķ���
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
	 * ��������״̬��ѯ�õ��̵Ķ���
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
	 * ������Ʒid��ѯ���������ڲ�ѯ���۳����ټ���Ʒ
	 * @param proId
	 * @return
	 */
	@RequestMapping("/getOrderByProId")
	@ResponseBody
	public List<Order> findOrderByProId(Integer proId){
		return orderService.findOrderByProId(proId);
	}
}
