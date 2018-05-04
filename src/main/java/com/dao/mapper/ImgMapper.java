package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Img;

@Repository
public interface ImgMapper {
	
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
