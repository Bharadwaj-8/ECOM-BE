package com.ecom.service;

import java.util.List;

import com.ecom.payload.CategoryDto;

public interface CategoryService {

//  create

  CategoryDto createCategory(CategoryDto category);


//  get

  List<CategoryDto> getCategories();


//  update
  
  CategoryDto update(CategoryDto c, Integer cid);


// delete
  
  void delete(Integer cid);
}
