package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Card;

@Repository
public interface CardMapper {

	/**
	 * 验证帐号密码是否正确
	 * @param card
	 * @return
	 */
	public Card findCardByTelAndPassword(Card card);
	
	/**
	 * 更新余额
	 * @param card
	 * @return
	 */
	public int updateCardBalance(Card card);
}
