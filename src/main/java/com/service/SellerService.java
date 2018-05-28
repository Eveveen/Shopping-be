package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.SellerMapper;
import com.entity.Seller;
import com.service.iface.SellerServiceIface;

@Service
public class SellerService implements SellerServiceIface {
	
	@Autowired
	private SellerMapper sellerMapper;

	@Override
	public Seller findSellerByNameAndPassword(Seller seller) {
		// TODO Auto-generated method stub
		return sellerMapper.findSellerByNameAndPassword(seller);
	}

	@Override
	public List<Seller> findAllSeller() {
		// TODO Auto-generated method stub
		return sellerMapper.findAllSeller();
	}

	@Override
	public int addSeller(Seller seller) {
		// TODO Auto-generated method stub
		sellerMapper.addSeller(seller);
		System.out.println(seller.getSellerId());
		return seller.getSellerId();
	}

	@Override
	public int updateSellerById(Seller seller) {
		// TODO Auto-generated method stub
		return sellerMapper.updateSellerById(seller);
	}

	@Override
	public int deleteSeller(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.deleteSeller(sellerId);
	}

	@Override
	public Seller findSellerBySellerId(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.findSellerBySellerId(sellerId);
	}

	@Override
	public Seller findSellerByTelphone(String telphone) {
		// TODO Auto-generated method stub
		return sellerMapper.findSellerByTelphone(telphone);
	}

}
