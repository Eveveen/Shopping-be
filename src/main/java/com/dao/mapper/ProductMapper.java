package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductMapper {

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
	
	/**
	 * ���ݹؼ����������������Ʒ
	 * @param map
	 * @return
	 */
	public List<Product> searchShopProduct(Map map);
	
	/**
	 * ������Ʒ״̬���ϼ��¼� 
	 * @param proId
	 * @return
	 */
	public int updateProductStatus(Integer proId);
	
	/**
	 * ������Ʒ���������ÿ�����Ʒ1�������
	 * @param proId
	 * @return
	 */
	public int updateProductScanNum(Integer proId);
	
}
