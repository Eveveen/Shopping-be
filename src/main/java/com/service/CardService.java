package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.CardMapper;
import com.entity.Card;
import com.service.iface.CardServiceIface;

@Service
public class CardService implements CardServiceIface {
	
	@Autowired
	private CardMapper cardMapper;

	@Override
	public Card findCardByTelAndPassword(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.findCardByTelAndPassword(card);
	}

	@Override
	public int updateCardBalance(Card card) {
		// TODO Auto-generated method stub
		return cardMapper.updateCardBalance(card);
	}

}
