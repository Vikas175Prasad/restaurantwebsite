package com.restaurant.models;

import java.util.List;

public class PlaceOrderReqModel {
	
	//{
//  "username": "dfsdg",
//  "lastname": "dsgsg",
//  "email": "test@test.com",
//  "address": "L-30, Street No.-1",
//  "country": "India",
//  "state": "Delhi",
//  "zip": "110044",
//  "transactionid": "dgsdg3535325",
//  "orderamount": "40",
//  "ordereddishes": "[{\"dishname\":\"Sweet Lassi\",\"quantity\":1,\"totalPrice\":40}]"
//}

	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private String country;

	private String state;

	private String zip;

	private String transactionid;

	private Long orderamount;

	private List<OrderedDishesReqModel> ordereddishes;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public Long getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(Long orderamount) {
		this.orderamount = orderamount;
	}

	public List<OrderedDishesReqModel> getOrdereddishes() {
		return ordereddishes;
	}

	public void setOrdereddishes(List<OrderedDishesReqModel> ordereddishes) {
		this.ordereddishes = ordereddishes;
	}
}
