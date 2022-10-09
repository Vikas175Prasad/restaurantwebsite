package com.restaurant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entities.OrderedDishes;
import com.restaurant.entities.Orders;
import com.restaurant.models.OrderedDishesReqModel;
import com.restaurant.models.PlaceOrderReqModel;
import com.restaurant.repos.OrderedDishesRepo;
import com.restaurant.repos.OrdersRepo;

@Service
public class OrdersService {

	@Autowired
	OrderedDishesRepo orderedDishesRepo;
	
	@Autowired
	OrdersRepo ordersRepo;

	public String placeOrder(PlaceOrderReqModel placeOrderRequestModel) {
		// TODO Auto-generated method stub
		
		List<OrderedDishes> orderedDishes = new ArrayList<>();
		List<OrderedDishesReqModel> orderedDishesReq = placeOrderRequestModel.getOrdereddishes();
		
		Orders order = new Orders(placeOrderRequestModel.getFirstname(), placeOrderRequestModel.getLastname(),
				placeOrderRequestModel.getEmail(), placeOrderRequestModel.getAddress(), placeOrderRequestModel.getCountry(),
				placeOrderRequestModel.getState(), placeOrderRequestModel.getZip(), placeOrderRequestModel.getTransactionid(),
				placeOrderRequestModel.getOrderamount(), null, "Pending", null);
		ordersRepo.save(order);
	
		for(OrderedDishesReqModel dishes: orderedDishesReq) {
			orderedDishes.add(new OrderedDishes(dishes.getDishname(), dishes.getQuantity(), dishes.getTotalPrice(), order));
		}
		
		orderedDishesRepo.saveAll(orderedDishes);
		return order.getOrderId();
	}
	
	
}
