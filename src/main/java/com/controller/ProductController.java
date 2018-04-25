package com.controller;

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

}
