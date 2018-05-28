package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Product;
import com.service.iface.ProductServiceIface;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceIface productService;
	
	/**
	 * �����Ʒ
	 * @param product
	 * @return
	 */
	@RequestMapping("/addProduct")
	@ResponseBody
	public boolean addProduct(@RequestBody Product product){
		System.out.println(product.getProName());
		if(productService.addProduct(product) != 0){
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("/editProduct")
	@ResponseBody
	public boolean updateProduct(Product product){
		if(productService.updateProduct(product) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public boolean deleteProduct(Integer proId){
		if(productService.deleteProduct(proId) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �鿴������������Ʒ
	 * @param shopId
	 * @return
	 */
	@RequestMapping("/getAllProduct")
	@ResponseBody
	public List<Product> findAllProduct(Integer shopId){
		return productService.findProductByShopId(shopId);
	}
	
	/**
	 * ��ѯ�õ��̵�δʧЧ����Ʒ
	 * @param shopId
	 * @return
	 */
	@RequestMapping("/getShopProductByProStatus")
	@ResponseBody
	public List<Product> findActiveProductByShopId(Integer shopId, Integer proStatus){
		Map<String ,Integer> map = new HashMap<String ,Integer>();
		map.put("shopId", shopId);
		map.put("proStatus", proStatus);
		return productService.findActiveProductByShopId(map);
	}
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public Product findProduct(Integer shopId, Integer proId){
		Map<String ,Integer> idMap = new HashMap<String ,Integer>();
		idMap.put("shopId", shopId);
		idMap.put("proId", proId);
		return productService.findProductByShopIdAndProId(idMap);
	}
	
	@RequestMapping("/getProductByProId")
	@ResponseBody
	public Product findProductByProId(Integer proId){
		return productService.findProductByProId(proId);
	}
	
	/**
	 * ���ݹؼ���������Ʒ
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchProduct")
	@ResponseBody
	public List<Product> searchProduct(String proName){
		return productService.searchProduct(proName);
	}
	
	/**
	 * ���ݹؼ����������������Ʒ
	 * @param shopId
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchShopProduct")
	@ResponseBody
	public List<Product> searchShopProduct(Integer shopId, String proName){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shopId", shopId);
		map.put("proName", proName);
		return productService.searchShopProduct(map);
	}
	
	/**
	 * ���ݹؼ�������������δʧЧ����Ʒ
	 * @param shopId
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchShopActiveProduct")
	@ResponseBody
	public List<Product> searchShopActiveProduct(Integer shopId, String proName){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shopId", shopId);
		map.put("proName", proName);
		return productService.searchShopActiveProduct(map);
	}
	
	/**
	 * ��Ʒ�¼�
	 * @param proId
	 * @return
	 */
	@RequestMapping("/updateProductStatus")
	@ResponseBody
	public boolean updateProductStatus(Integer proId){
		if(productService.updateProductStatus(proId) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �����������
	 * @param proId
	 * @return
	 */
	@RequestMapping("/updateProductScanNum")
	@ResponseBody
	public boolean updateProductScanNum(Integer proId){
		if(productService.updateProductScanNum(proId) == 1){
			return true;
		} else {
			return false;
		}
	}

}
