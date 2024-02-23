package com.ecom.entity;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ecom_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String orderStatus;

    private String paymentStatus;

    private Date orderCreated;

    private double totalAmount;

    private String billingAddress;


    private Date orderDelivered;
    
    @OneToOne
    private User user;
    
    
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    Set<OrderItem> items = new HashSet<>();

    

    public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Date getOrderCreated() {
		return orderCreated;
	}


	public void setOrderCreated(Date orderCreated) {
		this.orderCreated = orderCreated;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}


	public Date getOrderDelivered() {
		return orderDelivered;
	}


	public void setOrderDelivered(Date orderDelivered) {
		this.orderDelivered = orderDelivered;
	}


    public Order() {
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<OrderItem> getItems() {
		return items;
	}


	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}


	
}
