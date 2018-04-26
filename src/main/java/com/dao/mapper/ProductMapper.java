package com.dao.mapper;

import java.util.List;

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
}
