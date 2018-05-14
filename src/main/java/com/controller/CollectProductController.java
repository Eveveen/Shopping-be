package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.CollectProduct;
import com.service.iface.CollectProductServiceIface;

@Controller
public class CollectProductController {
	
	@Autowired
	private CollectProductServiceIface collectProductService;
	
	/**
	 * 获取该用户收藏的商品
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getCollectProduct")
	@ResponseBody
	public List<CollectProduct> findCollectProductByUserId(Integer userId){
		return collectProductService.findCollectProductByUserId(userId);
	}
	
	/**
	 * 根据用户id和商品id查询该商品是否已经被收藏
	 * @param collectProduct
	 * @return
	 */
	@RequestMapping("/isCollectProductExist")
	@ResponseBody
	public boolean findCollectProductByUserIdAndProId(CollectProduct collectProduct){
		if(collectProductService.findCollectProductByUserIdAndProId(collectProduct) == null) {
			return false;
		} else {
			return true;
		}			
	}
	
	/**
	 * 添加一个收藏的商品
	 * @param collectProduct
	 * @return
	 */
	@RequestMapping("/addCollectProduct")
	@ResponseBody
	public boolean addCollectProduct(CollectProduct collectProduct){
		if(collectProductService.addCollectProduct(collectProduct) == 1) {
			return true;
		} else {			
			return false;
		}
	}
	
	/**
	 * 移除一个收藏的商品
	 * @param cpId
	 * @return
	 */
	@RequestMapping("/deleteCollectProduct")
	@ResponseBody
	public boolean deleteCollectProduct(Integer cpId){
		if(collectProductService.deleteCollectProduct(cpId) == 1) {
			return true;
		} else {			
			return false;
		}
	}

}
