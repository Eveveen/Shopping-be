package com.service.iface;

import java.util.List;

import com.entity.Seller;

public interface SellerServiceIface {
	
	/**
	 * 根据用户名和密码登录
	 * @param seller
	 * @return
	 */
	public Seller findSellerByNameAndPassword(Seller seller);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Seller> findAllSeller();
	
	/**
	 * 添加卖家
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
	 * 删除卖家
	 * @return
	 */
	public int deleteSeller(Integer sellerId);

}
