package com.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Product {
	private Integer proId;
	private String proName;
	private Integer imgId;
	private String imgCode;
	private String description;
	private Double price;
	private Integer scanNum;
	private Integer category;
	private Date updateTime;
	private Integer proStatus;
	private Integer proNum;
	private Integer shopId;
	private Map<Integer,String> imgMap;
	private List<ProductImg> pImgList;
	private List<Integer> imgIdList;
	private List<Integer> deleteImgIdList;
	
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getScanNum() {
		return scanNum;
	}
	public void setScanNum(Integer scanNum) {
		this.scanNum = scanNum;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getProStatus() {
		return proStatus;
	}
	public void setProStatus(Integer proStatus) {
		this.proStatus = proStatus;
	}
	public Integer getProNum() {
		return proNum;
	}
	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Map<Integer, String> getImgMap() {
		return imgMap;
	}
	public void setImgMap(Map<Integer, String> imgMap) {
		this.imgMap = imgMap;
	}
	public List<ProductImg> getpImgList() {
		return pImgList;
	}
	public void setpImgList(List<ProductImg> pImgList) {
		this.pImgList = pImgList;
	}
	public List<Integer> getImgIdList() {
		return imgIdList;
	}
	public void setImgIdList(List<Integer> imgIdList) {
		this.imgIdList = imgIdList;
	}
	public List<Integer> getDeleteImgIdList() {
		return deleteImgIdList;
	}
	public void setDeleteImgIdList(List<Integer> deleteImgIdList) {
		this.deleteImgIdList = deleteImgIdList;
	}
}
