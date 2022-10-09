package com.restaurant.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//{
//    "username": "dfsdg",
//    "lastname": "dsgsg",
//    "email": "test@test.com",
//    "address": "L-30, Street No.-1",
//    "country": "India",
//    "state": "Delhi",
//    "zip": "110044",
//    "transactionid": "dgsdg3535325",
//    "orderamount": "40",
//    "ordereddishes": "[{\"dishname\":\"Sweet Lassi\",\"quantity\":1,\"totalPrice\":40}]"
//}

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Orders {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(updatable = false, nullable = false)
	private String orderId;

	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private String country;

	private String state;

	private String zip;

	private String transactionid;

	private Long orderamount;

	@OneToMany(mappedBy = "orderId")
	private List<OrderedDishes> dishes;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	@CreatedDate
	private Date orderdate;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date deliveredOn;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

	public List<OrderedDishes> getDishes() {
		return dishes;
	}

	public void setDishes(List<OrderedDishes> dishes) {
		this.dishes = dishes;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(Date deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	public Orders(String firstname, String lastname, String email, String address, String country, String state,
			String zip, String transactionid, Long orderamount, List<OrderedDishes> dishes,
			String status, Date deliveredOn) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.transactionid = transactionid;
		this.orderamount = orderamount;
		this.dishes = dishes;
		this.status = status;
		this.deliveredOn = deliveredOn;
	}

	public Orders() {
		super();
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", country=" + country + ", state=" + state + ", zip=" + zip
				+ ", transactionid=" + transactionid + ", orderamount=" + orderamount + ", dishes=" + dishes
				+ ", orderdate=" + orderdate + ", status=" + status + ", deliveredOn=" + deliveredOn + "]";
	}

}
