package com.codeWithRushikesh.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostResponse {
	
	
	private List<PostDto>  content;
	private int pageNumber;
	private int pageSize;
	private Long totolElements;
	private int totalPages;
	private boolean lastPage;

}
