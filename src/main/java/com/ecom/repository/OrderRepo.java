package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Order;
import com.ecom.entity.User;

public interface OrderRepo extends JpaRepository<Order,Integer>{

	Order findByUser(User user);

}
