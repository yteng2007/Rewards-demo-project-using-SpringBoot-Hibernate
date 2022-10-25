package com.example.demo.dto;

import java.sql.Date;

public class CustomerSpentRewardsDto {

	private Integer userId;

	private Integer spent;

	private Date purchaseDate;


	public CustomerSpentRewardsDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerSpentRewardsDto(Integer userId, Integer spent, Date purchaseDate) {
		super();
		this.userId = userId;
		this.spent = spent;
		this.purchaseDate = purchaseDate;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getSpent() {
		return spent;
	}


	public void setSpent(Integer spent) {
		this.spent = spent;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	@Override
	public String toString() {
		return "CustomerSpentRewardsDto [userId=" + userId + ", spent=" + spent + ", purchaseDate=" + purchaseDate
				+ "]";
	}

	
}
