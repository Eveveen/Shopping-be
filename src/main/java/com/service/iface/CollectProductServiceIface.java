package com.service.iface;

import java.util.List;

import com.entity.CollectProduct;

public interface CollectProductServiceIface {
	
	/**
	 * ��ѯ���û��ղص���Ʒ
	 * @param userId
	 * @return
	 */
	public List<CollectProduct> findCollectProductByUserId(Integer userId);
	
	/**
	 * �����û�id����Ʒid��ѯ����Ʒ�Ƿ��Ѿ����ղ�
	 * @param collectProduct
	 * @return
	 */
	public CollectProduct findCollectProductByUserIdAndProId(CollectProduct collectProduct);
	
	/**
	 * ���һ���ղ���Ʒ
	 * @param collectProduct
	 * @return
	 */
	public int addCollectProduct(CollectProduct collectProduct);
	
	/**
	 * �Ƴ�һ���ղص���Ʒ
	 * @param cpId
	 * @return
	 */
	public int deleteCollectProduct(Integer cpId);

}
