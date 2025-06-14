package com.codeWithRushikesh.repositories;

import com.codeWithRushikesh.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo   extends JpaRepository<Category, Integer>{
	

}
