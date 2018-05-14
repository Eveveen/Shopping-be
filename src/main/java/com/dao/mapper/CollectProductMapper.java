package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CollectProduct;

@Repository
public interface CollectProductMapper {
	
	/**
	 * 查询该用户收藏的商品
	 * @param userId
	 * @return
	 */
	public List<CollectProduct> findCollectProductByUserId(Integer userId);
	
	/**
	 * 根据用户id和商品id查询该商品是否已经被收藏
	 * @param collectProduct
	 * @return
	 */
	public CollectProduct findCollectProductByUserIdAndProId(CollectProduct collectProduct);
	
	/**
	 * 添加一个收藏商品
	 * @param collectProduct
	 * @return
	 */
	public int addCollectProduct(CollectProduct collectProduct);
	
	/**
	 * 移除一个收藏的商品
	 * @param cpId
	 * @return
	 */
	public int deleteCollectProduct(Integer cpId);

}
