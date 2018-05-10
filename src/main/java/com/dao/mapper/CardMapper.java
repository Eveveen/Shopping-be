package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Card;

@Repository
public interface CardMapper {

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
