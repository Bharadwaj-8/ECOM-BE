package com.ecom.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Order;
import com.ecom.payload.ApiResponse;
import com.ecom.payload.CartDto;
import com.ecom.payload.OrderDto;
import com.ecom.payload.OrderRequest;
import com.ecom.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	
	@Autowired
    private OrderService orderService;

    //for create order
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createOrder(
            @RequestBody OrderRequest orderRequest,
            Principal principal
    ) {
        //let suppose order is create success
        String username = principal.getName();
        this.orderService.createOrder(orderRequest,username);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Order is created successfully !!");
        apiResponse.setStatus(HttpStatus.OK);
        return ResponseEntity.ok(apiResponse);
    }

    // get orders
    
    @GetMapping("/get")
    public ResponseEntity<List<OrderDto>> getOrder() {
    	
    	List<OrderDto> orders = this.orderService.getOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    
    // delete orders
 
 @DeleteMapping("/{orderId}")
 public ApiResponse delete(@PathVariable Integer orderId)
    {
    	this.orderService.delete(orderId);
    	return new ApiResponse("product successfully deleted",true, HttpStatus.OK);
    }

 

    
    
    
//    @GetMapping("/")
//    public ResponseEntity<OrderDto> getOrder(
//            Principal principal
//    ) {
//        String username = principal.getName();
//        OrderDto order = this.orderService.getOrder(username);
//        return new ResponseEntity<>(order, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{productId}")
//    public ResponseEntity<OrderDto> removeOrder(
//            @PathVariable Integer productId
//            ,
//            Principal principal
//    ) {
//        String username = principal.getName();
//        OrderDto order = this.orderService.removeOrderItem(username, productId);
//        return new ResponseEntity<>(order, HttpStatus.OK);
//    }


    
    


  




	

}
