package com.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateProduct(product);
	}

	@Override
	public int deleteProduct(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.deleteProduct(proId);
	}

	@Override
	public List<Product> findProductByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return productMapper.findProductByShopId(shopId);
	}

	@Override
	public Product findProductByShopIdAndProId(Map idMap) {
		// TODO Auto-generated method stub
		return productMapper.findProductByShopIdAndProId(idMap);
	}

	@Override
	public Product findProductByProId(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.findProductByProId(proId);
	}

	@Override
	public List<Product> searchProduct(String proName) {
		// TODO Auto-generated method stub
		proName = "%" + proName + "%";
		return productMapper.searchProduct(proName);
	}

	@Override
	public List<Product> searchShopProduct(Map map) {
		// TODO Auto-generated method stub
		String proName = (String) map.get("proName");
		proName = "%" + proName + "%";
		map.put("proName", proName);
		return productMapper.searchShopProduct(map);
	}

	@Override
	public int updateProductStatus(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.updateProductStatus(proId);
	}

	@Override
	public int updateProductScanNum(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.updateProductScanNum(proId);
	}

	@Override
	public List<Product> findActiveProductByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return productMapper.findActiveProductByShopId(shopId);
	}

	@Override
	public List<Product> searchShopActiveProduct(Map map) {
		// TODO Auto-generated method stub
		String proName = (String) map.get("proName");
		proName = "%" + proName + "%";
		map.put("proName", proName);
		return productMapper.searchShopActiveProduct(map);
	}

}
