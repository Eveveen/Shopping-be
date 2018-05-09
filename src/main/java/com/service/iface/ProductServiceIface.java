package com.service.iface;

import java.util.List;
import java.util.Map;

import com.entity.Product;

public interface ProductServiceIface {
	
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
	
	/**
	 * 根据店铺编号和商品编号查询商品信息
	 * @param idMap
	 * @return
	 */
	public Product findProductByShopIdAndProId(Map idMap);
	
	/**
	 * 根据商品编号查询商品信息
	 * @param proId
	 * @return
	 */
	public Product findProductByProId(Integer proId);
	
	/**
	 * 根据关键字查询商品
	 * @param proName
	 * @return
	 */
	public List<Product> searchProduct(String proName);
}
