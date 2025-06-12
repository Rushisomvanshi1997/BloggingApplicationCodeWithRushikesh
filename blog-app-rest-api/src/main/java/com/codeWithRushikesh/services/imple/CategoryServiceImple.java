package com.codeWithRushikesh.services.imple;

import java.util.List;
import java.util.stream.Collectors;

import com.codeWithRushikesh.entities.Category;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithRushikesh.expections.ResourceNotFoundException;
import com.codeWithRushikesh.payloads.CategoryDto;
import com.codeWithRushikesh.repositories.CategoryRepo;
import com.codeWithRushikesh.services.CategoryService;


@Service
public class CategoryServiceImple  implements CategoryService {
	
	@Autowired
	 private CategoryRepo categoryRepo;
	
	@Autowired
	 private ModelMapper modelMapper;
	
	

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = this.modelMapper.map(categoryDto, Category.class);
   		this.categoryRepo.save(category);
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(category.getCategoryDescription());
		this.categoryRepo.save(category);
		
		return  this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public void delete(Integer categotyId) {
		
		Category category = this.categoryRepo.findById(categotyId)
				.orElseThrow(()->  new ResourceNotFoundException("Category", "CategoryId", categotyId));
		
		this.categoryRepo.delete(category);
		
	}

	@Override
	public CategoryDto getCategoryById(Integer categotyId) {
		
		Category category = this.categoryRepo.findById(categotyId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categotyId));
		
		return  this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
	  List<Category>  listofCategory=  this.categoryRepo.findAll();
	  
	  List<CategoryDto>  categoryDtoList = listofCategory
			  .stream()
			  .map( category->  this.modelMapper.map(category, CategoryDto.class))
			  .collect(Collectors.toList());
		return categoryDtoList;
	}
	
	

	 
	
	

}
