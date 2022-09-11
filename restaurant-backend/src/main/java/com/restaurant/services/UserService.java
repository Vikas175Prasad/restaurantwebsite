package com.restaurant.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entities.User;
import com.restaurant.models.UserCreateModel;
import com.restaurant.models.UserLoginModel;
import com.restaurant.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Transactional
	public void registerUser(UserCreateModel user) {

		User userEntity = new User(user.getUsername(), user.getPassword(), user.getEmail());
		userRepo.registerUser(userEntity);

	}

	public User loginUser(UserLoginModel user) {
		User userEntity = userRepo.loginUser(user.getEmail(), user.getPassword());
		return userEntity;
	}

}
