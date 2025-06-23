package com.codeWithRushikesh.services.imple;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.codeWithRushikesh.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.codeWithRushikesh.entities.Post;
import com.codeWithRushikesh.entities.User;
import com.codeWithRushikesh.expections.ResourceNotFoundException;
import com.codeWithRushikesh.payloads.PostDto;
import com.codeWithRushikesh.payloads.PostResponse;
import com.codeWithRushikesh.repositories.CategoryRepo;
import com.codeWithRushikesh.repositories.PostRepo;
import com.codeWithRushikesh.repositories.UserRepo;
import com.codeWithRushikesh.services.PostService;

@Service
public class PostServiceImple implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private  CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId) {
	
		Category category = this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException( "category", "category id", categoryId));
		
		User user = this.userRepo.findById(userId)
		.orElseThrow( () -> new ResourceNotFoundException("user", "user id", userId));
	
		 Post post =  this.modelMapper.map(postDto, Post.class);
		 
		 post.setAddedDate(new Date());
		 post.setImageName("default.png");
		 post.setUser(user);
		 post.setCategory(category);
		 
		Post newPost = this.postRepo.save(post);
		return  this.modelMapper.map(newPost, PostDto.class);
		
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
	 Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException( "Post", "PostId", postId));
		
	 post.setTitle( postDto.getTitle());
     post.setContent(postDto.getContent());
     post.setAddedDate(postDto.getAddedDate());
     post.setImageName(postDto.getImageName());
     
     
     	Post   updatPost =this.postRepo.save(post);
		return  this.modelMapper.map(updatPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		
       Post post  = this.postRepo.findById(postId)
    		   .orElseThrow(()-> new ResourceNotFoundException("PostId", "PostId", postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostResponse  getAllPost(Integer pageNumber , Integer pageSize ,String sortBy ,String sortDir) {
		
			  Sort sort =null;
			  if(sortDir.equalsIgnoreCase("asc")) {
				  
				  sort=Sort.by(sortBy).ascending();
				  
			  }else if(sortDir.equalsIgnoreCase("dsc")) {
				  
				  sort=Sort.by(sortBy).descending();
			  }
			 
				Pageable p = PageRequest.of(pageNumber, pageSize, sort);
				Page<Post> posts = this.postRepo.findAll(p);
				
				List<Post>  newPost= posts.getContent();
				
				List<PostDto> newPostDto = newPost
						.stream().map((post) -> this.modelMapper.map(post,PostDto.class))
					.collect(Collectors.toList());
				PostResponse postResponse = new PostResponse();
				
				postResponse.setContent(newPostDto);	
				postResponse.setPageNumber( posts.getNumber());
				postResponse.setPageSize(posts.getSize());
				postResponse.setTotolElements(posts.getTotalElements());
				postResponse.setTotalPages(posts.getTotalPages());
				postResponse.setLastPage(posts.isLast());
	
		return postResponse;
		
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
	Post post  = this.postRepo.findById(postId)
	     .orElseThrow(()-> new ResourceNotFoundException("PostId", "PostId", postId));
		
		return   this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new  ResourceNotFoundException("Category", "CategoryId",categoryId));
		
		 List<Post> posts=  this.postRepo.findByCategory(category);
		 
		List<PostDto>  newpostDto  = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	
		return newpostDto;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
	   User user = this.userRepo.findById(userId)
			   .orElseThrow(()-> new ResourceNotFoundException("UserId","UserId", userId));
	   
	    List<Post>  posts = this.postRepo.findByUser(user);
	        
	    List<PostDto>   newPostDto = posts.
	    		stream()
	    		.map((post)-> this.modelMapper.map(post, PostDto.class))
	    		.collect(Collectors.toList());
	    
		return newPostDto;
	}

}
