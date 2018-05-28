package com.dao.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entity.ProductImg;

@Repository
public interface ProductImgMapper {
	
	/**
	 * ���һ����ƷͼƬ��Ӧ�ļ�¼�����ؼ�¼id
	 * @param pImg
	 * @return
	 */
	public int addProductImg(ProductImg pImg);
	
	/**
	 * ������Ʒ��Ų�ѯ��Ӧ��ͼƬlist
	 * @param proId
	 * @return
	 */
	public List<ProductImg> findProductImgByProId(Integer proId);
	
	/**
	 * ������Ʒ��ź�ͼƬ��Ų�ѯ��¼�Ƿ����
	 * @param idMap
	 * @return
	 */
	public ProductImg findProductImgByProIdAndImgId(Map idMap);
	
	/**
	 * ������Ʒ��ź�ͼƬ���ɾ����Ʒ
	 * @param idMap
	 * @return
	 */
	public int deleteProductImgByProIdAndImgId(Map idMap);

}
