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
	 * 添加商品
	 * @param product
	 * @return
	 */
	@RequestMapping("/addProduct")
	@ResponseBody
	public boolean addProduct(@RequestBody Product product){
		System.out.println(product.getProName());
		if(productService.addProduct(product) == 1){
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
	 * 查看本店铺所有商品
	 * @param shopId
	 * @return
	 */
	@RequestMapping("/getAllProduct")
	@ResponseBody
	public List<Product> findAllProduct(Integer shopId){
		return productService.findProductByShopId(shopId);
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
	 * 根据关键字搜索商品
	 * @param proName
	 * @return
	 */
	@RequestMapping("/searchProduct")
	@ResponseBody
	public List<Product> searchProduct(String proName){
		return productService.searchProduct(proName);
	}

}
