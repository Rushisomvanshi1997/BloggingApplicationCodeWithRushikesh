package com.codeWithRushikesh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class BlogAppRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppRestApiApplication.class, args);
		
		
	  String key = Encoders.BASE64.encode(Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded());
	       System.out.println("JWT Secret: " + key);
		
		System.out.println(" GOOD MORNING  RUSHIKESH");
	}
	
	
	
	
	@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();
		
	}
	
	

}
