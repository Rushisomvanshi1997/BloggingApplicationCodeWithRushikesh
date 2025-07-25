package com.codeWithRushikesh.expections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException  extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldvalue;
	String fieldValue ;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldvalue) {
		super(String.format("%s  not found with %s: %s",resourceName,fieldName,fieldvalue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldvalue;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s  not found with %s: %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	

}
