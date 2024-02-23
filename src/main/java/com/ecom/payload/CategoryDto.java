	package com.ecom.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryDto {

    private Integer id;
    
    @NotBlank
    @Size(min = 4, max = 500)
    private String title;
    
    @NotBlank
    private String desc;
    
    
    private String bannerName;
    
    
    
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CategoryDto(Integer id, String title, String desc, String bannerName) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.bannerName = bannerName;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getBannerName() {
		return bannerName;
	}



	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
    
    
    
    
    
    
}