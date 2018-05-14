package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.Cart;

@Repository
public interface CartMapper {
	
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
	
	/**
	 * һ��ɾ��������¼
	 * @param cartIds
	 * @return
	 */
	public int deleteCartByIds(String[] cartIds);
	
	/**
	 * ������Ʒ��ź��û���Ų�ѯ���ﳵ��Ϣ
	 * @param idMap
	 * @return
	 */
	public Cart findCartByProIdAndUserId(Map idMap);

}
