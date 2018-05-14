package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.CollectProduct;
import com.entity.CollectShop;
import com.service.iface.CollectShopServiceIface;

@Controller
public class CollectShopController {
	
	@Autowired
	private CollectShopServiceIface collectShopService;
	
	/**
	 * ��ȡ���û��ղصĵ���
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getCollectShop")
	@ResponseBody
	public List<CollectShop> findCollectShopByUserId(Integer userId){
		return collectShopService.findCollectShopByUserId(userId);
	}
	
	/**
	 * �����û�id����Ʒid��ѯ����Ʒ�Ƿ��Ѿ����ղ�
	 * @param CollectShop
	 * @return
	 */
	@RequestMapping("/isCollectShopExist")
	@ResponseBody
	public boolean findCollectShopByUserIdAndShopId(CollectShop collectShop){
		if(collectShopService.findCollectShopByUserIdAndShopId(collectShop) == null) {
			return false;
		} else {
			return true;
		}			
	}
	
	/**
	 * ���һ���ղصĵ���
	 * @param collectShop
	 * @return
	 */
	@RequestMapping("/addCollectShop")
	@ResponseBody
	public boolean addCollectShop(CollectShop collectShop){
		if(collectShopService.addCollectShop(collectShop) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	/**
	 * �Ƴ�һ���ղصĵ���
	 * @param csId
	 * @return
	 */
	@RequestMapping("/deleteCollectShop")
	@ResponseBody
	public boolean deleteCollectShop(Integer csId){
		if(collectShopService.deleteCollectShop(csId) == 1) {
			return true;
		} else {			
			return false;
		}
	}

}
