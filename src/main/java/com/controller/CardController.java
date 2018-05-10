package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Card;
import com.service.iface.CardServiceIface;

@Controller
public class CardController {
	
	@Autowired
	private CardServiceIface cardService;
	
	/**
	 * ��֤�ֻ��ź������Ƿ�ƥ��
	 * @param card
	 * @return
	 */
	@RequestMapping("/pay")
	@ResponseBody
	public Card findCardByTelAndPassword(Card card) {
		return cardService.findCardByTelAndPassword(card);
	}
	
	/**
	 * �������
	 * @param card
	 * @return
	 */
	@RequestMapping("/updateCardBalance")
	@ResponseBody
	public boolean updateCardBalance(Card card) {
		if(cardService.updateCardBalance(card) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
