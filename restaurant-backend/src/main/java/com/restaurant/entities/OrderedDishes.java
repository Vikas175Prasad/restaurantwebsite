package com.restaurant.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_dishes")
public class OrderedDishes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// [{\"dishname\":\"Sweet Lassi\",\"quantity\":1,\"totalPrice\":40}]
	private String dishname;

	private Long quantity;

	private Long totalPrice;

	@ManyToOne
	@JoinColumn(name = "orderId", nullable = false)
	private Orders orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public OrderedDishes(String dishname, Long quantity, Long totalPrice, Orders orderId) {
		super();
		this.dishname = dishname;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}

	public OrderedDishes() {
		super();
	}

	@Override
	public String toString() {
		return "OrderedDishes [id=" + id + ", dishname=" + dishname + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + "]";
	}
}
