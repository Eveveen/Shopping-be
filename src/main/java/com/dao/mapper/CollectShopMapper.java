package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CollectShop;

@Repository
public interface CollectShopMapper {
	
	/**
	 * ��ѯ���û��ղصĵ���
	 * @param userId
	 * @return
	 */
	public List<CollectShop> findCollectShopByUserId(Integer userId);
	
	/**
	 *  �����û�id�͵���id��ѯ�õ����Ƿ��Ѿ����ղ�
	 * @param collectShop
	 * @return
	 */
	public CollectShop findCollectShopByUserIdAndShopId(CollectShop collectShop);
	
	/**
	 * ���һ���ղص���
	 * @param collectShop
	 * @return
	 */
	public int addCollectShop(CollectShop collectShop);
	
	/**
	 * �Ƴ�һ���ղصĵ���
	 * @param csId
	 * @return
	 */
	public int deleteCollectShop(Integer csId);

}
