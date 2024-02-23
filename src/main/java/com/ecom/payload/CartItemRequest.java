package com.ecom.payload;

public class CartItemRequest {
	
	 private Integer productId;
	    private Integer quantity;
	    
	    private Integer userId;
	    

		public CartItemRequest() {
			super();
			// TODO Auto-generated constructor stub
		}


		public CartItemRequest(Integer productId, Integer quantity, Integer userId) {
			super();
			this.productId = productId;
			this.quantity = quantity;
			this.userId = userId;
		}


		public Integer getProductId() {
			return productId;
		}


		public void setProductId(Integer productId) {
			this.productId = productId;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public Integer getUserId() {
			return userId;
		}


		public void setUserId(Integer userId) {
			this.userId = userId;
		}
	    
	    
	    
	    


}
