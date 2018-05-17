package com.dao.mapper;

import java.util.List;

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
	 * ���ݵ��̱�Ų�ѯ������Ϣ
	 * @param shopId
	 * @return
	 */
	public Shop findShopByShopId(Integer shopId);
	
	/**
	 * ��ѯ���еĵ���
	 * @return
	 */
	public List<Shop> findAllShop();
	
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
	
	/**
	 * ���ݵ��̵�״̬��ѯ���̣�����Աʹ��
	 * @param shopStatus
	 * @return
	 */
	public List<Shop> findShopByShopStatus(Integer shopStatus);

}
