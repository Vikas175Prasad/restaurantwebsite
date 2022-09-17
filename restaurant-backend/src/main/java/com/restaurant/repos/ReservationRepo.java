package com.restaurant.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.restaurant.entities.Reservations;

@Repository
public class ReservationRepo {
	
	@PersistenceContext
	private EntityManager em;

	public void bookReservation(Reservations reservation) {
		em.persist(reservation);
		
	}

}
