package com.codeWithRushikesh.payloads;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min = 2   , message=" UserName  must be min  6 chars !! ")
	private String name;
	
	
	@NotEmpty
	@Email( message= " Email address is not valid !! ")
	@Pattern(
		        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
		        message = "Email address is not valid !! "
		    )
	private String email;
	
	
	@NotEmpty
	@Size(min = 3 , max = 12 , message="Password is must be min of 3 chars and max of 12  chars !! ")
	private String password;
	
	
	@NotEmpty
	private String about;

	
	

}
