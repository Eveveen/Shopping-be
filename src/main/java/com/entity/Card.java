package com.entity;

public class Card {
	
	private Integer cardId;
	private Integer userId;
	private Integer telphone;
	private String passwrod;
	private Double balance;
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTelphone() {
		return telphone;
	}
	public void setTelphone(Integer telphone) {
		this.telphone = telphone;
	}
	public String getPasswrod() {
		return passwrod;
	}
	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
