package com.service.iface;

import com.entity.Card;

public interface CardServiceIface {
	
	/**
	 * ��֤�ʺ������Ƿ���ȷ
	 * @param card
	 * @return
	 */
	public Card findCardByTelAndPassword(Card card);
	
	/**
	 * �������
	 * @param card
	 * @return
	 */
	public int updateCardBalance(Card card);

}
