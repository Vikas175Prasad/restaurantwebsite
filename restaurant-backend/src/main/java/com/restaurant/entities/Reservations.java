package com.restaurant.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "reservations")
@EntityListeners(AuditingEntityListener.class)
public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "reservation_date")
	private Date reservationDate;

	@Column(name = "time")
	private String time;

	@Column(name = "number_of_attendees")
	private String numberOfAttendees;

	@Column(name = "additional_requests")
	private String additionalRequests;

	@CreatedDate
	private Instant createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNumberOfAttendees() {
		return numberOfAttendees;
	}

	public void setNumberOfAttendees(String numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}

	public String getAdditionalRequests() {
		return additionalRequests;
	}

	public void setAdditionalRequests(String additionalRequests) {
		this.additionalRequests = additionalRequests;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservations(String name, String phone, String email, Date reservationDate, String time,
			String numberOfAttendees, String additionalRequests) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.reservationDate = reservationDate;
		this.time = time;
		this.numberOfAttendees = numberOfAttendees;
		this.additionalRequests = additionalRequests;
	}

}
