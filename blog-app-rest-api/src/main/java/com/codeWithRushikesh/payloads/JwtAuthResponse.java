package com.codeWithRushikesh.payloads;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtAuthResponse {

	
	  private String accessToken;
	  
	    private String tokenType = "Bearer";
	    
}
