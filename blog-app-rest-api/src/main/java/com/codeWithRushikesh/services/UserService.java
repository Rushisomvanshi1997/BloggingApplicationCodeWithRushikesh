package com.codeWithRushikesh.services;

import java.util.List;

import com.codeWithRushikesh.payloads.UserDto;

public interface UserService {
	
	
	UserDto  createUser (UserDto  user);
	UserDto updateUser(UserDto user ,Integer id);
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers ();
	
	void deleteUser (Integer userId);
	
	
	

}
