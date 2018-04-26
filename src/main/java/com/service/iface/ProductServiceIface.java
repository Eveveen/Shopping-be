package com.service.iface;

import java.util.List;

import com.entity.Product;

public interface ProductServiceIface {
	
	/**
	 * �����Ʒ
	 * @param product
	 * @return
	 */
	public int addProduct(Product product);
	
	/**
	 * ������Ʒid����product������id�����и���
	 * @param product
	 * @return
	 */
	public int updateProduct(Product product);
	
	/**
	 * ɾ����Ʒ
	 * @param proId
	 * @return
	 */
	public int deleteProduct(Integer proId);
	
	/**
	 * ��ѯ�õ����µ�������Ʒ
	 * @param shopId
	 * @return
	 */
	public List<Product> findProductByShopId(Integer shopId);
}
