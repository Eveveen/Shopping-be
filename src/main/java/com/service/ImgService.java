package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.ImgMapper;
import com.entity.Img;
import com.service.iface.ImgServiceIface;

@Service
public class ImgService implements ImgServiceIface {
	
	@Autowired
	private ImgMapper imgMapper;

	@Override
	public Img getImgById(Integer imgId) {
		// TODO Auto-generated method stub
		return imgMapper.getImgById(imgId);
	}

	@Override
	public int createImg(Img img) {
		// TODO Auto-generated method stub
		System.out.println(img.getImgCode());
		imgMapper.createImg(img);
		return img.getImgId();
//		return img.getImgId();
	}

}
