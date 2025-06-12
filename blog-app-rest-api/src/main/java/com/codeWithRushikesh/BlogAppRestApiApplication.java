package com.codeWithRushikesh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppRestApiApplication.class, args);
		
		System.out.println(" GOOD MORNING  RUSHIKESH");
	}
	
	
	@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();
		
	}
	
	

}
