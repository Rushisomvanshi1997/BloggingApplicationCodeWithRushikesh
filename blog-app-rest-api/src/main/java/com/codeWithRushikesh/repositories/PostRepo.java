package com.codeWithRushikesh.repositories;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithRushikesh.entities.Post;
import com.codeWithRushikesh.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
	
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
