package com.ecom.impl;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Cart;
import com.ecom.entity.CartItem;
import com.ecom.entity.Order;
import com.ecom.entity.OrderItem;
import com.ecom.entity.User;
import com.ecom.exception.ResourceNotFoundException;
import com.ecom.payload.CartDto;
import com.ecom.payload.OrderDto;
import com.ecom.payload.OrderRequest;
import com.ecom.repository.CartRepo;
import com.ecom.repository.OrderRepo;
import com.ecom.repository.UserRepository;
import com.ecom.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	

    @Autowired
    private CartRepo cartRepo;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepo orderRepo;

	
    @Autowired
    private ModelMapper modelMapper;

	

	@Override
	public void createOrder(OrderRequest request, String username) {
		
		
		//actual order create

        Cart cart = this.cartRepo.findById(request.getCartId()).orElseThrow(() -> new ResourceNotFoundException("Cart", "cart id ", request.getCartId() + ""));

        Order order = new Order();
        Set<OrderItem> orderItems = cart.getItems().stream().map(cartItem -> new OrderItem(cartItem.getProduct(), cartItem.getQuantity(), order)).collect(Collectors.toSet());

        order.setItems(orderItems);
        order.setBillingAddress(request.getAddress());
        order.setOrderCreated(new Date());
        order.setOrderStatus("PENDING");
        order.setPaymentStatus("NOT PAID");
        order.setOrderDelivered(null);

        final double[] totalPrice = {0};
        cart.getItems().forEach(cartItem -> {
            totalPrice[0] = totalPrice[0] + cartItem.getTotalPrice();
        });

        order.setTotalAmount(totalPrice[0]);
        //calculate the total price:
        User user = this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", "user id", username + ""));


        order.setUser(user);

        //how to save order to db
        this.orderRepo.save(order);

        cart.getItems().clear();

        this.cartRepo.save(cart);



    }



	@Override
	public List<OrderDto> getOrder() {
		
		List<Order> all = this.orderRepo.findAll();
        List<OrderDto> data = all.stream().map((order -> this.modelMapper.map(order, OrderDto.class))).collect(Collectors.toList());
        return data;
	}



	@Override
	public void delete(Integer orderId) {
		
		Order order = this.orderRepo.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("order", "order id", orderId + ""));
    	this.orderRepo.delete(order);
		
	}



	



//	@Override
//	public OrderDto getOrder(String username) {
//		
//		User user = this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", " username ", username));
//        Order order = user.getOrder();
//        return this.modelMapper.map(order, OrderDto.class);
//	}
//
//
//
//
//	@Override
//	public OrderDto removeOrderItem(String username, Integer productId) {
//		
//		User user = this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User ", " username ", username));
//        Order order = this.orderRepo.findByUser(user);
//        Set<OrderItem> items = order.getItems();
//        boolean b = items.removeIf((item) -> item.getProduct().getId().equals(productId));
//        System.out.println(b);
//        Order order1 = this.orderRepo.save(order);
//        System.out.println(order1.getItems().size());
//        return this.modelMapper.map(order1, OrderDto.class);
//	}
		
	}


