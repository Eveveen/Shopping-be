package com.service.iface;

import com.entity.ProductImg;

public interface ProductImgServiceIface {
	
	/**
	 * 添加一条商品图片对应的记录，返回记录id
	 * @param pImg
	 * @return
	 */
	public int addProductImg(ProductImg pImg);

}
