package com.codeWithRushikesh.services.imple;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeWithRushikesh.entities.User;
import com.codeWithRushikesh.expections.ResourceNotFoundException;
import com.codeWithRushikesh.payloads.UserDto;
import com.codeWithRushikesh.repositories.RoleRepo;
import com.codeWithRushikesh.repositories.UserRepo;
import com.codeWithRushikesh.services.UserService;

@Service
public class UserServiceImple  implements UserService{
	
	
	@Autowired
	private  UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
	
		
		User user =	this.getDtoToUser(userDto);
		User  userSaved =this.userRepo.save(user);
		return  this.getUserToDto(userSaved);
		
		
	}

	
	
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId ){
		
			User  user = userRepo.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException( "User" ,"Id", userId));
			
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			user.setAbout(userDto.getAbout());
			
			User  userUpdate =this.userRepo.save(user);
			UserDto  newUserDto =this.getUserToDto(userUpdate);
		return newUserDto;
		
	}

	@Override
	public UserDto getUserById(Integer userId) {

	
		User user = userRepo.findById(userId)
				.orElseThrow(  ()-> new ResourceNotFoundException  ("User" ,"Id", userId));
		
		
		return  this.getUserToDto(user);
	}
	
	

	@Override
	public List<UserDto> getAllUsers() {
		
		 List<User>  listofUsersd = userRepo.findAll();
		 
		List<UserDto>  userDtoList = listofUsersd
				.stream()
				.map( user -> this.getUserToDto(user))
				.collect(Collectors.toList());
		
		return userDtoList;
	}
	
	
	

	@Override
	public void deleteUser(Integer userId) {
	
		User user = userRepo.findById(userId)
				.orElseThrow(  ()-> new ResourceNotFoundException  ("User" ,"Id", userId));
		
		this.userRepo.delete(user);
	}
	
	
     public  User getDtoToUser( UserDto  userDto) {
    	 
    	 User user =new User();
    	 
    	 this.modelMapper.map(userDto, user);
    	 
    	/* user.setId( userDto.getId());
    	 user.setAbout(userDto.getAbout());	
    	 user.setEmail(userDto.getEmail());
    	 user.setName(userDto.getName());
    	 user.setPassword(userDto.getPassword());*/
    	
    	 return user;
    	 
     }
     
     
    public  UserDto  getUserToDto ( User user) {
    	
    	
    	UserDto  userDto =new UserDto();
    	this.modelMapper.map(user, userDto);

    	/* 
    	userDto.setAbout(user.getAbout());
    	userDto.setEmail(user.getEmail());
    	userDto.setId(user.getId());
    	userDto.setName(user.getName());
    	userDto.setPassword(user.getPassword()); */

    	return userDto;
		
	}
    
   

}
