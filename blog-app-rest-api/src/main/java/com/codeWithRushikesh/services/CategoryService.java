package com.codeWithRushikesh.services;

import java.util.List;

import com.codeWithRushikesh.payloads.CategoryDto;

public interface CategoryService {
	
	
	//create
    CategoryDto  createCategory(CategoryDto categoryDto);
    
    // update 
    CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
    
    //delete
    void delete( Integer categotyId);
    
    //getCategoryByid
    CategoryDto getCategoryById(Integer categotyId);
    
    //getAllCategory
    List<CategoryDto> getCategories(); 
   

}
