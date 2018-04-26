package com.service.iface;

import com.entity.Shop;

public interface ShopServiceIface {
	
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
