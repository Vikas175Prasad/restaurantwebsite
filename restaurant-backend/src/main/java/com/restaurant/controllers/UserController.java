package com.restaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entities.User;
import com.restaurant.models.UserCreateModel;
import com.restaurant.models.UserLoginModel;
import com.restaurant.services.UserService;

@RestController
@RequestMapping(value = "/restaurant/user")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping(value = "/register")
	public ResponseEntity<Object> registerUser(@RequestBody UserCreateModel user) {
		ResponseEntity<Object> response = null;
		try {
			userService.registerUser(user);
			response = new ResponseEntity<Object>("User Registered", HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println("Exception:" + e);
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@CrossOrigin
	@PostMapping(value = "/login")
	public ResponseEntity<Object> loginUser(@RequestBody UserLoginModel user) {
		ResponseEntity<Object> response = null;
		try {
			User userEntity = userService.loginUser(user);
			if (null != userEntity) {
				response = new ResponseEntity<Object>(userEntity, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>("User doesn't exist", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			System.out.println("Exception:" + e);
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
