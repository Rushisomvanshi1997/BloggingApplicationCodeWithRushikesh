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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codeWithRushikesh.config.AppConstants;
import com.codeWithRushikesh.payloads.ApiResponce;
import com.codeWithRushikesh.payloads.PostDto;
import com.codeWithRushikesh.payloads.PostResponse;
import com.codeWithRushikesh.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/")
@Tag(name = "Post", description = "Post management APIs")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// create post Rushikesh
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	 @Operation(summary = "Create  Post", description = "Returns a single Post")
	public ResponseEntity< PostDto> createPost ( @RequestBody  PostDto postDto,
			@PathVariable  Integer userId,
			@PathVariable   Integer categoryId ){
		
		 PostDto  createPostdto = this.postService.
				 createPost(postDto, userId, categoryId);
		return   new  ResponseEntity<PostDto>( createPostdto ,HttpStatus.CREATED);
	
	}
	
	//get post by User
	 @GetMapping("/user/{userId}/posts")
	  public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer  userId ){
		  
			List<PostDto> postDto  =  this.postService.getPostByUser(userId);
	
		  return   new  ResponseEntity<List<PostDto>>(postDto ,HttpStatus.OK);
	  }
	
	 // get Post by category
	 @GetMapping("/category/{categoryId}/posts")
	 public ResponseEntity<List<PostDto>> getPostByCategory( @PathVariable Integer categoryId){
		 
		List<PostDto>  postDtoList=  this.postService.getPostByCategory(categoryId);
		 
		 return  new ResponseEntity<List<PostDto>>(postDtoList ,HttpStatus.OK);
	 }
	
	 // find all post 
	 @GetMapping("/posts")
	 public ResponseEntity<PostResponse> getAllPost(
		 @RequestParam ( value="pageNumber" ,defaultValue = AppConstants.PAGE_NUMBER  , required = false) Integer pageNumber,
		 @RequestParam ( value="pageSize" ,defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize,
		 @RequestParam ( value="sortBy" ,defaultValue = AppConstants.SORTY_BY, required = false) String sortBy,
		 @RequestParam ( value="sortDir" ,defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
		){
		 
		 PostResponse  postResponse = this.postService.getAllPost( pageNumber, pageSize ,sortBy,sortDir);
		 	return  new ResponseEntity<PostResponse>(  postResponse ,HttpStatus.OK);
	   
	 }
	 
	 // update  post 
	 @PutMapping("/post/{postId}")
	 public ResponseEntity< PostDto>  updatePost(@RequestBody  PostDto postDto , 
			 @PathVariable Integer postId){

		  PostDto   updatepost =   this.postService.updatePost(postDto, postId);
		 return new ResponseEntity<PostDto>( updatepost ,HttpStatus.OK);
		 
	 }
	 
	 //delete post
	 @DeleteMapping("/post/{postId}")
	 public ApiResponce   deletePost( @PathVariable Integer postId){
		 
	 	  this.postService.deletePost(postId);
		 return  new ApiResponce("Post is successfully deletedd !! ", true );
		 
	 }
	 
	 
	 
	 
	
}
