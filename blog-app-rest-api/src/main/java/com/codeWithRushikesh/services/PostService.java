package com.codeWithRushikesh.services;

import java.util.List;

import com.codeWithRushikesh.payloads.PostDto;

public interface PostService {
	
	
	
	//create
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	// get all post
	List<PostDto> getAllPost();
	
	//get single post
	PostDto getPostById(Integer postId);
	
	// get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	// get all post by User
	List<PostDto> getPostByUser(Integer categoryId);
	
	
	
	
	

}
