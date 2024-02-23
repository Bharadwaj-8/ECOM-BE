package com.ecom.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "description")
    private String desc;

    private String bannerName;
    
    
    
    

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





	public Set<Product> getProducts() {
		return products;
	}





	public void setProducts(Set<Product> products) {
		this.products = products;
	}





	public Category(Integer id, String title, String desc, String bannerName, Set<Product> products) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.bannerName = bannerName;
		this.products = products;
	}





	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}





	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}
