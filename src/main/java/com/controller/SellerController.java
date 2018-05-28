package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private Seller tempSeller = new Seller();
	
	/**
	 * �����û����������ж��Ƿ��¼�ɹ�
	 * @param seller
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Seller Login(Seller seller) {

		String name = seller.getSellerName();
		String password = seller.getPassword();
		
		Seller s = new Seller();
		s.setSellerName(name);
		s.setPassword(password);

		if (sellerService.findSellerByNameAndPassword(s) != null) {
			return sellerService.findSellerByNameAndPassword(s);
		} else {
			return null;
		}
	}
	
	/**
	 * �����ȡ��֤��ʱ������ȡ�����ֻ��źͶ�Ӧ����֤�뱣������ʱ�Ķ�����
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveCode/{sendCode}/{telphone}")
	@ResponseBody
	public boolean saveCode(@PathVariable(value="sendCode") String sendCode, @PathVariable(value="telphone") String telphone){
		System.out.println("saveCode==" + sendCode + "::::" + telphone);
		if(sendCode == null || telphone == null){
			return false;
		} else {
//			if(tempUser.getTelphone() != user.getTelphone() || tempUser.getValidateCode() == null){				
			tempSeller.setValidateCode(sendCode);
			tempSeller.setTelphone(telphone);
//			}
			return true;
		}
	}
	
	/**
	 * ��֤��֤�룬�����յ��Ĳ�����tempSeller�е����ݽ��бȶ�
	 * @param seller
	 * @return
	 */
	@RequestMapping("/verifyCode")
	@ResponseBody
	public String verifyCode(@RequestBody Seller seller){
		System.out.println("tem:" + tempSeller.getValidateCode() + "::: seller=" + seller.getValidateCode() 
				+ ":::tel:::" + seller.getTelphone() + "::TEM::" + tempSeller.getTelphone());
		if(sellerService.findSellerByTelphone(seller.getTelphone()) != null || tempSeller.getValidateCode() == null){
			System.out.println("AAA");
			return "false";
		} else if(tempSeller.getValidateCode().equals(seller.getValidateCode()) 
				&& tempSeller.getTelphone().equals(seller.getTelphone())&&sellerService.findSellerByTelphone(seller.getTelphone()) == null){
			return "true";
		} else {
			System.out.println("BBB");
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
	public boolean addSeller(Seller seller){
		if(sellerService.addSeller(seller) != 0){
			return true;
		} else {
			return false;
		}
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
	public boolean deleteSeller(Integer sellerId){
		if(sellerService.deleteSeller(sellerId) == 1){
			return true;			
		} else {
			return false;
		}
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
