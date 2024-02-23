package com.ecom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payload.ApiResponse;
import com.ecom.payload.CategoryDto;
import com.ecom.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CategoryDto categoryDto
    ) {
        CategoryDto category1 = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category1, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(

    ) {
        List<CategoryDto> categories =
                this.categoryService.getCategories();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }
    
    //update category

    @PutMapping("/{cid}")
    public ResponseEntity<CategoryDto> update(
            @RequestBody CategoryDto categoryDto,
            @PathVariable Integer cid
    ) {
        CategoryDto update = this.categoryService.update(categoryDto, cid);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


    //delete funtionality
    @DeleteMapping("/{cid}")
    public ApiResponse delete(@PathVariable Integer cid)
    {
    	this.categoryService.delete(cid);
    	return new ApiResponse("category successfully deleted",true, HttpStatus.OK);
    }
    
    
}