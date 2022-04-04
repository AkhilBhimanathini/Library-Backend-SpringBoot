package com.assignment.service;


import java.util.List;

import com.assignment.model.Books;

public interface BookService {
	
	void createbook(Books book) throws Exception;
	public List<Books> getAllbooks();
	public Books getBook(int id);
	public Books updatebook(int id,String name,String author,String dept);
	public Books deletebook(int id);

	

}
