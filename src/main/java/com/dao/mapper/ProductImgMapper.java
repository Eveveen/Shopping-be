package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.ProductImg;

@Repository
public interface ProductImgMapper {
	
	/**
	 * 添加一条商品图片对应的记录，返回记录id
	 * @param pImg
	 * @return
	 */
	public int addProductImg(ProductImg pImg);
	
	/**
	 * 根据商品编号查询对应的图片list
	 * @param proId
	 * @return
	 */
	public List<ProductImg> findProductImgByProId(Integer proId);
	
	/**
	 * 根据商品编号和图片编号查询记录是否存在
	 * @param idMap
	 * @return
	 */
	public ProductImg findProductImgByProIdAndImgId(Map idMap);
	
	/**
	 * 根据商品编号和图片编号删除商品
	 * @param idMap
	 * @return
	 */
	public int deleteProductImgByProIdAndImgId(Map idMap);

}
