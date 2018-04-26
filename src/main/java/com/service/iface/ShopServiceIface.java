package com.service.iface;

import com.entity.Shop;

public interface ShopServiceIface {
	
	/**
	 * 查询该卖家的店铺
	 * @param sellerId
	 * @return
	 */
	public Shop findShopBySellerId(Integer sellerId);
	
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

}
