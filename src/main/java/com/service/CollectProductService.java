package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.CollectProductMapper;
import com.entity.CollectProduct;
import com.service.iface.CollectProductServiceIface;

@Service
public class CollectProductService implements CollectProductServiceIface {
	
	@Autowired
	private CollectProductMapper collectProductMapper;

	@Override
	public List<CollectProduct> findCollectProductByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return collectProductMapper.findCollectProductByUserId(userId);
	}
	
	@Override
	public CollectProduct findCollectProductByUserIdAndProId(CollectProduct collectProduct) {
		// TODO Auto-generated method stub
		return collectProductMapper.findCollectProductByUserIdAndProId(collectProduct);
	}

	@Override
	public int addCollectProduct(CollectProduct collectProduct) {
		// TODO Auto-generated method stub
		return collectProductMapper.addCollectProduct(collectProduct);
	}

	@Override
	public int deleteCollectProduct(Integer cpId) {
		// TODO Auto-generated method stub
		return collectProductMapper.deleteCollectProduct(cpId);
	}

}
