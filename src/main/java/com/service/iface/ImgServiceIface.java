package com.service.iface;

import com.entity.Img;

public interface ImgServiceIface {

	/**
	 * ����ͼƬid��ȡͼƬ
	 * @param imgId
	 * @return
	 */
	public Img getImgById(Integer imgId);
	
	/**
	 * ���ͼƬ��������ͼƬid
	 * @param img
	 * @return
	 */
	public int createImg(Img img);
}
