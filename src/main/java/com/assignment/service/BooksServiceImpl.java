package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.Books;
import com.assignment.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BookService {

	
	@Autowired
	BooksRepository repo;
	
	@Override
	public void createbook(Books book) throws Exception{
		// TODO Auto-generated method stub
		if(book.getName()==null) {
			throw new Exception();
		}
		repo.save(book);
	}

	@Override
	public List<Books> getAllbooks() {
		// TODO Auto-generated method stub
		return repo.findAll();

	}
	
	@Override
	public Books getBook(int id) {
		// TODO Auto-generated method stub
		Optional<Books> b=repo.findById(id);
		if(b.isPresent()) {
			Books book = b.get();
		//	repo.save(updatedbook);
			return book;
		}
		return null;
	}

	@Override
	public Books updatebook(int id, String name, String author, String dept) {
		// TODO Auto-generated method stub
		Optional<Books> b=repo.findById(id);
		if(b.isPresent()) {
			Books updatedbook = b.get();
			updatedbook.setName(name);
			updatedbook.setAuthor(author);
			updatedbook.setCategory(dept);
			repo.save(updatedbook);
			return updatedbook;
		}
		return null;
		
	}
 
	@Override
	public Books deletebook(int id) {
		// TODO Auto-generated method stub
		Optional<Books> b=repo.findById(id);
		if(b.isPresent()) {
		 Books book=b.get();
		 repo.deleteById(id);
		 return book;	
		}
	   return null;
	}


}
