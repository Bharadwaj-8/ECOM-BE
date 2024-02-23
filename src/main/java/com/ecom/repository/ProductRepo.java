package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Category;
import com.ecom.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	 List<Product> findByCategory(Category category);

	    List<Product> findByIsLiveFalse();

	    List<Product> findByInStockFalse();


}
