package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.CollectShopMapper;
import com.entity.CollectShop;
import com.service.iface.CollectShopServiceIface;

@Service
public class CollectShopService implements CollectShopServiceIface{
	
	@Autowired
	private CollectShopMapper collectShopMapper;

	@Override
	public List<CollectShop> findCollectShopByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return collectShopMapper.findCollectShopByUserId(userId);
	}
	
	@Override
	public CollectShop findCollectShopByUserIdAndShopId(CollectShop collectShop) {
		// TODO Auto-generated method stub
		return collectShopMapper.findCollectShopByUserIdAndShopId(collectShop);
	}

	@Override
	public int addCollectShop(CollectShop collectShop) {
		// TODO Auto-generated method stub
		return collectShopMapper.addCollectShop(collectShop);
	}

	@Override
	public int deleteCollectShop(Integer csId) {
		// TODO Auto-generated method stub
		return collectShopMapper.deleteCollectShop(csId);
	}
}
