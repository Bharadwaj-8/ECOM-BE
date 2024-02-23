package com.ecom.payload;

import com.ecom.entity.Product;

public class OrderItemDto {
	
	
	 private Integer id;


	    private ProductDto product;

	    private Integer quantity;

		public Integer getId() {
			return id;
		}
		

		public void setId(Integer id) {
			this.id = id;
		}

		

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public ProductDto getProduct() {
			return product;
		}


		public void setProduct(ProductDto product) {
			this.product = product;
		}
	    
	    
	    

}
