package com.service.iface;

import java.util.List;

import com.entity.Seller;

public interface SellerServiceIface {
	
	/**
	 * �����û����������¼
	 * @param seller
	 * @return
	 */
	public Seller findSellerByNameAndPassword(Seller seller);
	
	/**
	 * ��ѯ�����û�
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
	 * 
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
