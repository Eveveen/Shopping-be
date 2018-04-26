package com.entity;

public class Address {
	private Integer addressId;
	private String consignee;
	private Integer telphone;
	private String area;
	private String addressName;
	private Integer addressStatus;
	private Integer zipCode;
	private Integer userId;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public Integer getTelphone() {
		return telphone;
	}
	public void setTelphone(Integer telphone) {
		this.telphone = telphone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public Integer getAddressStatus() {
		return addressStatus;
	}
	public void setAddressStatus(Integer addressStatus) {
		this.addressStatus = addressStatus;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
