package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.ShopMapper;
import com.entity.Shop;
import com.service.iface.ShopServiceIface;

@Service
public class ShopService implements ShopServiceIface {
	
	@Autowired
	private ShopMapper shopMapper;

	@Override
	public Shop findShopBySellerId(Integer sellerId) {
		// TODO Auto-generated method stub
		return shopMapper.findShopBySellerId(sellerId);
	}

	@Override
	public int addShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.addShop(shop);
	}

	@Override
	public int updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.updateShop(shop);
	}

	@Override
	public int deleteShop(Integer shopId) {
		// TODO Auto-generated method stub
		return shopMapper.deleteShop(shopId);
	}

}
