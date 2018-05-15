package com.dao.mapper;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 根据关键字搜索店铺里的商品
	 * @param map
	 * @return
	 */
	public List<Product> searchShopProduct(Map map);
	
	/**
	 * 更改商品状态，上架下架 
	 * @param proId
	 * @return
	 */
	public int updateProductStatus(Integer proId);
	
	/**
	 * 更改商品浏览次数，每点击商品1次则更新
	 * @param proId
	 * @return
	 */
	public int updateProductScanNum(Integer proId);
	
}
