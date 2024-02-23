package com.ecom.service;



import java.util.List;

import com.ecom.payload.CartDto;
import com.ecom.payload.OrderDto;
import com.ecom.payload.OrderRequest;


public interface OrderService {
	
	void createOrder(OrderRequest request,String username);
	
	 List<OrderDto> getOrder();
	 
	 
		
	 
		void delete(Integer orderId);


}
