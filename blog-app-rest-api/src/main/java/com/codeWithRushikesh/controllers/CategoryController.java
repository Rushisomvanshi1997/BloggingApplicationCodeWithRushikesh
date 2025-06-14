package com.codeWithRushikesh.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeWithRushikesh.payloads.ApiResponce;
import com.codeWithRushikesh.payloads.CategoryDto;
import com.codeWithRushikesh.services.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;
	
	
	//create add  category 
	@PostMapping("/")
	public  ResponseEntity<CategoryDto>  createCategory ( @Valid @RequestBody  CategoryDto categoryDto  ){
		
		CategoryDto crateCategory =this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>( crateCategory ,HttpStatus.CREATED);
		
	}
	
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto creaCategoryDto ,@PathVariable("categoryId") Integer categoryId){
		
	        CategoryDto updateCategoryDto = this.categoryService.updateCategory(creaCategoryDto, categoryId);
		
		return ResponseEntity.ok(updateCategoryDto);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponce> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		     this.categoryService.delete(categoryId);
		return new ResponseEntity<ApiResponce>( new ApiResponce("Delete Category Successfully !!",false) , HttpStatus.OK);
	}

	
	//findAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> findAllCategory(){
		
		return ResponseEntity.ok(this.categoryService.getCategories());
		
	}
	
	//findbyId
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryfindById (@PathVariable("categoryId") Integer categoryId){
		
		return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));
		
	}
	
	
	
	

}
