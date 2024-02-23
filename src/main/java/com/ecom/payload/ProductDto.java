package com.ecom.payload;

public class ProductDto {
	
	 private Integer id;

	    private String name;

	    private String description;

	    private Double price;

	    private Boolean isLive = false;

	    private Boolean inStock = true;

	    private Integer rating;

	    private String imageName;

	    private CategoryDto category;

	    private String brandName = "learn Code With Durgesh";
	    

		public ProductDto() {
			super();
			// TODO Auto-generated constructor stub
		}


		public ProductDto(Integer id, String name, String description, Double price, Boolean isLive, Boolean inStock,
				Integer rating, String imageName, CategoryDto category, String brandName) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.isLive = isLive;
			this.inStock = inStock;
			this.rating = rating;
			this.imageName = imageName;
			this.category = category;
			this.brandName = brandName;
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


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public Boolean getIsLive() {
			return isLive;
		}


		public void setIsLive(Boolean isLive) {
			this.isLive = isLive;
		}


		public Boolean getInStock() {
			return inStock;
		}


		public void setInStock(Boolean inStock) {
			this.inStock = inStock;
		}


		public Integer getRating() {
			return rating;
		}


		public void setRating(Integer rating) {
			this.rating = rating;
		}


		public String getImageName() {
			return imageName;
		}


		public void setImageName(String imageName) {
			this.imageName = imageName;
		}


		public CategoryDto getCategory() {
			return category;
		}


		public void setCategory(CategoryDto category) {
			this.category = category;
		}


		public String getBrandName() {
			return brandName;
		}


		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

	    
	    

}
