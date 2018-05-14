package com.service.iface;

import java.util.List;

import com.entity.CollectShop;

public interface CollectShopServiceIface {
	
	/**
	 * 查询该用户收藏的店铺
	 * @param userId
	 * @return
	 */
	public List<CollectShop> findCollectShopByUserId(Integer userId);
	
	/**
	 *  根据用户id和店铺id查询该店铺是否已经被收藏
	 * @param collectShop
	 * @return
	 */
	public CollectShop findCollectShopByUserIdAndShopId(CollectShop collectShop);
	
	/**
	 * 添加一个收藏店铺
	 * @param collectProduct
	 * @return
	 */
	public int addCollectShop(CollectShop collectShop);
	
	/**
	 * 移除一个收藏的店铺
	 * @param cpId
	 * @return
	 */
	public int deleteCollectShop(Integer csId);


}
