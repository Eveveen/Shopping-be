package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.ProductMapper;
import com.entity.Product;
import com.service.iface.ProductServiceIface;

@Service
public class ProductService implements ProductServiceIface {

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.addProduct(product);
	}

}
