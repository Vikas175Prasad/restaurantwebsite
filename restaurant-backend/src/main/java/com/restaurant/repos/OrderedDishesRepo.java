package com.restaurant.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entities.OrderedDishes;

@Repository
public interface OrderedDishesRepo extends JpaRepository<OrderedDishes, Long>{

}
