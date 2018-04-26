package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductMapper {

	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	public int addProduct(Product product);
	
	/**
	 * 根据商品id更新product，店铺id不进行更新
	 * @param product
	 * @return
	 */
	public int updateProduct(Product product);
	
	/**
	 * 删除商品
	 * @param proId
	 * @return
	 */
	public int deleteProduct(Integer proId);
	
	/**
	 * 查询该店铺下的所有商品
	 * @param shopId
	 * @return
	 */
	public List<Product> findProductByShopId(Integer shopId);
}
