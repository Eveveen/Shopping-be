package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Shop;

@Repository
public interface ShopMapper {
	
	/**
	 * 查询该卖家的店铺
	 * @param sellerId
	 * @return
	 */
	public Shop findShopBySellerId(Integer sellerId);
	
	/**
	 * 根据店铺编号查询店铺信息
	 * @param shopId
	 * @return
	 */
	public Shop findShopByShopId(Integer shopId);
	
	/**
	 * 查询所有的店铺
	 * @return
	 */
	public List<Shop> findAllShop();
	
	/**
	 * 新增店铺，每个卖家只能新建一个店铺
	 * @param shop
	 * @return
	 */
	public int addShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return
	 */
	public int updateShop(Shop shop);
	
	/**
	 * 删除店铺
	 * @param shopId
	 * @return
	 */
	public int deleteShop(Integer shopId);
	
	/**
	 * 根据店铺的状态查询店铺，管理员使用
	 * @param shopStatus
	 * @return
	 */
	public List<Shop> findShopByShopStatus(Integer shopStatus);

}
