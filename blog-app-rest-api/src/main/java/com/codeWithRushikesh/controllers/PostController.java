package com.codeWithRushikesh.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeWithRushikesh.payloads.PostDto;
import com.codeWithRushikesh.services.PostService;


@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// create post Rushikesh
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity< PostDto> createPost ( @RequestBody  PostDto postDto,
			@PathVariable  Integer userId,
			@PathVariable   Integer categoryId ){
		
		 PostDto  createPostdto = this.postService.
				 createPost(postDto, userId, categoryId);
		return   new  ResponseEntity<PostDto>( createPostdto ,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	

}
