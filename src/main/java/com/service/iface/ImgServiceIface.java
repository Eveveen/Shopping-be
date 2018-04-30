package com.service.iface;

import com.entity.Img;

public interface ImgServiceIface {

	/**
	 * 根据图片id获取图片
	 * @param imgId
	 * @return
	 */
	public Img getImgById(Integer imgId);
	
	/**
	 * 添加图片，并返回图片id
	 * @param img
	 * @return
	 */
	public int createImg(Img img);
}
