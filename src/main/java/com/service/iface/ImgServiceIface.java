package com.service.iface;

import com.entity.Img;

public interface ImgServiceIface {

	public Img getImgById(Integer imgId);
	public int createImg(Img img);
}
