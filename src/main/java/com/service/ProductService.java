package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapper.ProductImgMapper;
import com.dao.mapper.ProductMapper;
import com.entity.Product;
import com.entity.ProductImg;
import com.service.iface.ProductServiceIface;

@Service
public class ProductService implements ProductServiceIface {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductImgMapper pimgMapper;
	
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		int result = productMapper.addProduct(product);
		for(int imgId : product.getImgIdList()){
			ProductImg pimg = new ProductImg();
			pimg.setImgId(imgId);
			pimg.setProId(product.getProId());
			pimgMapper.addProductImg(pimg);
		}
		return result;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		List<ProductImg> pimgList = pimgMapper.findProductImgByProId(product.getProId());
		/*List<Integer> imgIdList = new ArrayList<Integer>();
		Product pro = productMapper.findProductByProId(product.getProId());
		for(ProductImg pimg : pimgList){
			imgIdList.add(pimg.getImgId());
		}
		product.setImgIdList(imgIdList);*/
		if(product.getImgIdList()!=null){
			
			for(int imgId : product.getImgIdList()){
				Map<String, Integer> idMap = new HashMap<String, Integer> ();
				idMap.put("proId", product.getProId());
				idMap.put("imgId", imgId);
				if(pimgMapper.findProductImgByProIdAndImgId(idMap) == null){  // 如果原来不存在，添加			
					ProductImg pimg = new ProductImg();
					pimg.setImgId(imgId);
					pimg.setProId(product.getProId());
					pimgMapper.addProductImg(pimg);
				} else {
					if(product.getDeleteImgIdList() != null){					
						for(ProductImg pi : pimgList){
							for(int delImgId : product.getDeleteImgIdList()){						
								if(pi.getImgId() == delImgId){
									Map<String, Integer> delIdMap = new HashMap<String, Integer> ();
									delIdMap.put("proId", product.getProId());
									delIdMap.put("imgId", delImgId);
									pimgMapper.deleteProductImgByProIdAndImgId(delIdMap);
								}
							}
						}
					}
					
				}
			}
		}
		return productMapper.updateProduct(product);
	}

	@Override
	public int deleteProduct(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.deleteProduct(proId);
	}

	@Override
	public List<Product> findProductByShopId(Integer shopId) {
		// TODO Auto-generated method stub
		return productMapper.findProductByShopId(shopId);
	}

	@Override
	public Product findProductByShopIdAndProId(Map idMap) {
		// TODO Auto-generated method stub
		return productMapper.findProductByShopIdAndProId(idMap);
	}

	@Override
	public Product findProductByProId(Integer proId) {
		// TODO Auto-generated method stub
		List<ProductImg> pimgList = pimgMapper.findProductImgByProId(proId);
		List<Integer> imgIdList = new ArrayList<Integer>();
		Product product = productMapper.findProductByProId(proId);
		for(ProductImg pimg : pimgList){
			imgIdList.add(pimg.getImgId());
		}
		product.setImgIdList(imgIdList);
		return product;
	}

	@Override
	public List<Product> searchProduct(String proName) {
		// TODO Auto-generated method stub
		proName = "%" + proName + "%";
		return productMapper.searchProduct(proName);
	}

	@Override
	public List<Product> searchShopProduct(Map map) {
		// TODO Auto-generated method stub
		String proName = (String) map.get("proName");
		proName = "%" + proName + "%";
		map.put("proName", proName);
		return productMapper.searchShopProduct(map);
	}

	@Override
	public int updateProductStatus(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.updateProductStatus(proId);
	}

	@Override
	public int updateProductScanNum(Integer proId) {
		// TODO Auto-generated method stub
		return productMapper.updateProductScanNum(proId);
	}

	@Override
	public List<Product> findActiveProductByShopId(Map map) {
		// TODO Auto-generated method stub
		return productMapper.findActiveProductByShopId(map);
	}

	@Override
	public List<Product> searchShopActiveProduct(Map map) {
		// TODO Auto-generated method stub
		String proName = (String) map.get("proName");
		proName = "%" + proName + "%";
		map.put("proName", proName);
		return productMapper.searchShopActiveProduct(map);
	}

}
