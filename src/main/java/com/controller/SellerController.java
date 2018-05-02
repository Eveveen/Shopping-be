package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Seller;
import com.entity.User;
import com.service.iface.SellerServiceIface;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerServiceIface sellerService;
	
	/**
	 * �����û����������ж��Ƿ��¼�ɹ�
	 * @param seller
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String Login(Seller seller) {

		String name = seller.getSellerName();
		String password = seller.getPassword();
		
		Seller s = new Seller();
		s.setSellerName(name);
		s.setPassword(password);

		if (sellerService.findSellerByNameAndPassword(s) != null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	/**
	 * ��ȡ���е�����
	 * @return
	 */
	@RequestMapping("/getAllSeller")
	@ResponseBody
	public List<Seller> getAllSeller(){
		return sellerService.findAllSeller();
	}
	
	/**
	 * �������
	 * @param seller
	 * @return
	 */
	@RequestMapping("/addSeller")
	@ResponseBody
	public int addSeller(Seller seller){
		return sellerService.addSeller(seller);
	}
	
	/**
	 * ��������
	 * @param seller
	 * @return
	 */
	@RequestMapping("/editSeller")
	@ResponseBody
	public boolean editSeller(Seller seller){
		if(sellerService.updateSellerById(seller) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ɾ������
	 * @param sellerId
	 * @return
	 */
	@RequestMapping("/deleteSeller")
	@ResponseBody
	public int deleteSeller(Integer sellerId){
		return sellerService.deleteSeller(sellerId);
	}
	
	/**
	 * �������ұ�Ų�ѯ������Ϣ
	 * @param sellerId
	 * @return
	 */
	@RequestMapping("/getSeller")
	@ResponseBody
	public Seller findSellerBySellerId(Integer sellerId) {
		return sellerService.findSellerBySellerId(sellerId);
	}

}
