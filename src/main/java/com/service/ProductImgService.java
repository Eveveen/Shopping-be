package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.ProductImgMapper;
import com.service.iface.ProductImgServiceIface;

@Service
public class ProductImgService implements ProductImgServiceIface {

	@Autowired
	private ProductImgMapper pimgMapper;
	
	@Override
	public int addProductImg(com.entity.ProductImg pImg) {
		// TODO Auto-generated method stub
		return pimgMapper.addProductImg(pImg);
	}

}
