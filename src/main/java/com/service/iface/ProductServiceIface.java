package com.service.iface;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * ���ݵ��̱�ź���Ʒ��Ų�ѯ��Ʒ��Ϣ
	 * @param idMap
	 * @return
	 */
	public Product findProductByShopIdAndProId(Map idMap);
	
	/**
	 * ������Ʒ��Ų�ѯ��Ʒ��Ϣ
	 * @param proId
	 * @return
	 */
	public Product findProductByProId(Integer proId);
	
	/**
	 * ���ݹؼ��ֲ�ѯ��Ʒ
	 * @param proName
	 * @return
	 */
	public List<Product> searchProduct(String proName);
}
