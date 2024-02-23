package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Cart;
import com.ecom.entity.User;

public interface CartRepo extends  JpaRepository<Cart,Integer>{
	
	Cart findByUser(User user);

}
