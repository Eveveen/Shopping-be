package com.service.iface;

import java.util.List;

import com.entity.CollectShop;

public interface CollectShopServiceIface {
	
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
	 * @param collectProduct
	 * @return
	 */
	public int addCollectShop(CollectShop collectShop);
	
	/**
	 * �Ƴ�һ���ղصĵ���
	 * @param cpId
	 * @return
	 */
	public int deleteCollectShop(Integer csId);


}
