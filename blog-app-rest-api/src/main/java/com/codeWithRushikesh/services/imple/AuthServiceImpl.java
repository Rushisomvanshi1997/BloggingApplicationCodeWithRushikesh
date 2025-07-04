package com.codeWithRushikesh.services.imple;

import org.springframework.security.authentication.AuthenticationManager;

import com.codeWithRushikesh.config.security.JwtTokenProvider;
import com.codeWithRushikesh.payloads.LoginDto;
import com.codeWithRushikesh.services.AuthService;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	   private AuthenticationManager authenticationManager;
	   
	   private  JwtTokenProvider JwtTokenProvider;
	   
	   
	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = JwtTokenProvider.generateToken(authentication);

        return token;
	}

}
