package com.codeWithRushikesh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codeWithRushikesh.repositories.UserRepo;


@SpringBootTest
class BlogAppRestApiApplicationTests {

   @Autowired
   public UserRepo userRepo;
   
   
	 
	@Test
	void contextLoads() {
		
		
	}

	@Test
	public void  testRepo() {
		
		
      String className	=  this.userRepo.getClass().getName();
      String packageName = this.userRepo.getClass().getPackageName();
		
      System.out.println(className);
      System.out.println();
		
	}
	
	
	
	
	
	
}
