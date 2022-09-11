package com.restaurant.repos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.restaurant.entities.User;

@Repository
public class UserRepo {

	@PersistenceContext
	EntityManager em;

	public void registerUser(User userEntity) {

		em.persist(userEntity);

	}

	public User loginUser(String email, String password) {
		try {
			TypedQuery<User> userQuery = em.createNamedQuery("findUserByEmailAndPassword", User.class);
			userQuery.setParameter(1, email);
			userQuery.setParameter(2, password);
			return userQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

}
