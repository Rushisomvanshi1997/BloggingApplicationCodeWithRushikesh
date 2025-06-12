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
import com.codeWithRushikesh.payloads.UserDto;
import com.codeWithRushikesh.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
		@Autowired
		private	UserService usrService;
		
		// create user
		
		@PostMapping("/")
		public ResponseEntity< UserDto>  createDto (@Valid @RequestBody UserDto userDto){
			 UserDto createUserDto = this.usrService.createUser(userDto);
			 return  new  ResponseEntity<>(createUserDto ,HttpStatus.CREATED);
			 
		}
		
		// update User
		@PutMapping("/{userId}")
		public  ResponseEntity<UserDto>  updateUser  (@Valid @RequestBody UserDto userDto , @PathVariable("userId") Integer userId) {
			
			  UserDto updateDto =  this.usrService.updateUser(userDto, userId);
			  
			return  ResponseEntity.ok(updateDto);
		
		}
		
		
		// delete User
		@DeleteMapping ("/{userId}")
		public  ResponseEntity<ApiResponce>  deleteUser( @PathVariable("userId") Integer userId ){
			
			this.usrService.deleteUser(userId);
			return  new ResponseEntity<ApiResponce>(new ApiResponce("User Deleted Successfully" , true) , HttpStatus.OK );
			
		}
		
		
		// get user by id 
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId){
		
			this.usrService.getUserById(userId);
			return ResponseEntity.ok(this.usrService.getUserById(userId));
			
		}
		
		
		
		//getAllUser
		@GetMapping("/")
		public ResponseEntity< List<UserDto>> getAllUser()
		{
			
			return  ResponseEntity.ok(this.usrService.getAllUsers());
		}
		
		
		
		
		
		
		
		
	
	
	
	
}
	
	
	

