package com.codeWithRushikesh.services.imple;

import java.util.Date;
import java.util.List;
import com.codeWithRushikesh.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeWithRushikesh.entities.Post;
import com.codeWithRushikesh.entities.User;
import com.codeWithRushikesh.expections.ResourceNotFoundException;
import com.codeWithRushikesh.payloads.PostDto;
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
	
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		
		
	}

	@Override
	public List<PostDto> getAllPost() {

		return null;
	}

	@Override
	public PostDto getPostById(Integer postId) {
	
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
	
		return null;
	}

	@Override
	public List<PostDto> getPostByUser(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
