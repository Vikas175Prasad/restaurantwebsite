package com.restaurant.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.models.PlaceOrderReqModel;
import com.restaurant.services.OrdersService;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@CrossOrigin
	@PostMapping(value = "/place_order", consumes = "application/json")
	public ResponseEntity<Object> placeOrder(@RequestBody PlaceOrderReqModel placeOrderRequestModel ){
		
		ResponseEntity<Object> res = null;
		try {
			String orderId = ordersService.placeOrder(placeOrderRequestModel);
			Map<String, String> orderIdMap = new HashMap<String, String>();
			orderIdMap.put("orderId", orderId);
			res = new ResponseEntity<Object>(orderIdMap, HttpStatus.CREATED);
		}catch(Exception e) {
			System.out.println("Exception:"+e);
			res = new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return res;
		
	}
}
