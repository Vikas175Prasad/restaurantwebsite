package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.models.BookReservationModel;
import com.restaurant.services.ReservationService;

@RestController
@RequestMapping(value = "/restaurant/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@CrossOrigin
	@PostMapping(value = "/book-reservation")
	public ResponseEntity<Object> bookReservation(@RequestBody BookReservationModel bookReservationModel) {
		ResponseEntity<Object> response = null;
		try {
			reservationService.bookReservation(bookReservationModel);
			response = new ResponseEntity<Object>("Reservation successful", HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Exception:" + e);
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
