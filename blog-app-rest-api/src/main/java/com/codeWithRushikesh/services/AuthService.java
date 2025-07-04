package com.codeWithRushikesh.services;

import com.codeWithRushikesh.payloads.LoginDto;

public interface AuthService {
	
	 String login(LoginDto loginDto);
}
