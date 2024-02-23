package com.ecom.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class JwtRequest {
	
	
	@Email(message = "Invalid Email Id !!")
	 private String username;
	
	//@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Invalid Password !!")
    @NotBlank
	    private String password;
	    
	    
		public JwtRequest() {
			super();
			// TODO Auto-generated constructor stub
		}


		public JwtRequest(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}

	    
		
	    

}
