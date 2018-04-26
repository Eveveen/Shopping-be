package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Seller;

@Repository
public interface SellerMapper {
	
	/**
	 * �����û����������¼
	 * @param seller
	 * @return
	 */
	public Seller findSellerByNameAndPassword(Seller seller);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<Seller> findAllSeller();
	
	/**
	 * �������
	 * @param seller
	 * @return
	 */
	public int addSeller(Seller seller);
	
	/**
	 * ��������
	 * @param seller
	 * @return
	 */
	public int updateSellerById(Seller seller);
	
	/**
	 * ɾ������
	 * @return
	 */
	public int deleteSeller(Integer sellerId);


}
