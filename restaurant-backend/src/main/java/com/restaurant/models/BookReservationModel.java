package com.restaurant.models;

public class BookReservationModel {

	private String name;

	private String phone;

	private String email;

	private String reservationDate;

	private String time;

	private String numberOfAttendees;

	private String additionalRequests;

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

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
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

}
