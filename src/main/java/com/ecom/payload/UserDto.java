package com.ecom.payload;

import java.util.Date;

public class UserDto {
	
	 private Integer id;
	    private String name;
	    private String email;

	    private String password;

	    private String imageName;

	    private String address;

	    private String about;

	    private Date date;

		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserDto(Integer id, String name, String email, String password, String imageName, String address,
				String about, Date date) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.imageName = imageName;
			this.address = address;
			this.about = about;
			this.date = date;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

	    
	    
}
