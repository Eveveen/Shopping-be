package com.service.iface;

import java.util.List;

import com.entity.Cart;

public interface CartServiceIface {
	
	/**
	 * ��ѯ��ǰ�û��Ĺ��ﳵ
	 * @param userId
	 * @return
	 */
	public List<Cart> findCartByUserId(Integer userId);
	
	/**
	 * ���ﳵ���1����¼
	 * @param cart
	 * @return
	 */
	public int addCart(Cart cart);
	
	/**
	 * �༭���ﳵ
	 * @param cart
	 * @return
	 */
	public int updateCart(Cart cart);
	
	/**
	 * ɾ�����ﳵ�е�1����¼
	 * @param cartId
	 * @return
	 */
	public int deleteCart(Integer cartId);

}
