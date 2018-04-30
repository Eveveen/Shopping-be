package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Img;

@Repository
public interface ImgMapper {
	
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
