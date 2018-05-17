package com.service;

import java.util.List;

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
	public Shop findShopByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return shopMapper.findShopByShopId(shopId);
	}
	
	@Override
	public List<Shop> findAllShop() {
		// TODO Auto-generated method stub
		return shopMapper.findAllShop();
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

	@Override
	public List<Shop> findShopByShopStatus(Integer shopStatus) {
		// TODO Auto-generated method stub
		return shopMapper.findShopByShopStatus(shopStatus);
	}

}
