package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Shop;

@Repository
public interface ShopMapper {
	
	/**
	 * ��ѯ�����ҵĵ���
	 * @param sellerId
	 * @return
	 */
	public Shop findShopBySellerId(Integer sellerId);
	
	/**
	 * �������̣�ÿ������ֻ���½�һ������
	 * @param shop
	 * @return
	 */
	public int addShop(Shop shop);
	
	/**
	 * ���µ���
	 * @param shop
	 * @return
	 */
	public int updateShop(Shop shop);
	
	/**
	 * ɾ������
	 * @param shopId
	 * @return
	 */
	public int deleteShop(Integer shopId);

}