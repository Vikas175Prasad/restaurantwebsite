package com.restaurant.models;

public class OrderedDishesReqModel {

	//ordereddishes": "[{\"dishname\":\"Sweet Lassi\",\"quantity\":1,\"totalPrice\":40}]"
	
	private String dishname;
	
	private Long quantity;
	
	private Long totalPrice;

	public String getDishname() {
		return dishname;
	}

	public void setDishname(String dishname) {
		this.dishname = dishname;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
