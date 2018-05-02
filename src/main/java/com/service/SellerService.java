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

	public Seller findSellerByNameAndPassword(Seller seller) {
		// TODO Auto-generated method stub
		return sellerMapper.findSellerByNameAndPassword(seller);
	}

	public List<Seller> findAllSeller() {
		// TODO Auto-generated method stub
		return sellerMapper.findAllSeller();
	}

	public int addSeller(Seller seller) {
		// TODO Auto-generated method stub
		return sellerMapper.addSeller(seller);
	}

	public int updateSellerById(Seller seller) {
		// TODO Auto-generated method stub
		return sellerMapper.updateSellerById(seller);
	}

	public int deleteSeller(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.deleteSeller(sellerId);
	}

	public Seller findSellerBySellerId(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.findSellerBySellerId(sellerId);
	}

}
