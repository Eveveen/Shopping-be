package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.Img;

@Repository
public interface ImgMapper {
	
	public Img getImgById(Integer imgId);
    public int createImg(Img img);

}
