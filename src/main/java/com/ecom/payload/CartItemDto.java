package com.ecom.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItemDto {
	
	 private Integer id;
	    private ProductDto product;
	    private Integer quantity;
	    
	    
	    @JsonProperty("total_price")
	    public Double getTotalPrice()
	    {
	        return quantity*this.product.getPrice();
	    }
	    
	  


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public ProductDto getProduct() {
			return product;
		}


		public void setProduct(ProductDto product) {
			this.product = product;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

	    

}
