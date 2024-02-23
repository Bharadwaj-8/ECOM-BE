package com.ecom.service;

import java.util.List;

import com.ecom.payload.ProductDto;

public interface ProductService {
	
	 //create

    ProductDto create(ProductDto product, Integer catId);

    //update

    ProductDto update(ProductDto product,Integer productId);

    //delete
    
    void delete(Integer productId);
    
    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductOfCategory(Integer catId);

    //all products that is not live

    List<ProductDto> getProductNotLive();

    //all product that is outof stock

    List<ProductDto> getProductOutOfStock();

	ProductDto getById(Integer productId);



}
