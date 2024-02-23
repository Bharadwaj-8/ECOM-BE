package com.ecom.payload;

import java.util.HashSet;
import java.util.Set;

public class CartDto {
	
	private Integer id;
    private UserDto user;
    private Set<CartItemDto> items = new HashSet<>();
    
    
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public Set<CartItemDto> getItems() {
		return items;
	}


	public void setItems(Set<CartItemDto> items) {
		this.items = items;
	}


    
    
}
