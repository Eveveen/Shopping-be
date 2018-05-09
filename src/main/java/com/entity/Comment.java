package com.entity;

import java.util.Date;

public class Comment {
	
	private Integer commentId;
	private Integer shopId;
	private Integer proId;
	private Integer userId;
	private String description;
	private Double rate;
	private Date createTime;
//	private Long createTime;
	
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
//	public Long getCreateTime() {
//		return createTime;
//	}
//	public void setCreateTime(Long createTime) {
//		this.createTime = createTime;
//	}
//	
}
