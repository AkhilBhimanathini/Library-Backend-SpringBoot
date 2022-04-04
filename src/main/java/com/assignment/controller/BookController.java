package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Books;
import com.assignment.service.BookService;

@RestController
@RequestMapping("/api/")
public class BookController {
	
	@Autowired
	BookService obj;
	
	@PostMapping(value="/create/book/")
	public ResponseEntity<Books> createBook(@RequestBody Books book) throws Exception {
		if (book.getName()==null) {

   		 return new ResponseEntity<Books>(book, HttpStatus.BAD_REQUEST);		
		}
		obj.createbook(book);
		return new ResponseEntity<Books>(book,HttpStatus.OK);
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/get-all-books")
	public ResponseEntity<List<Books>> getAllBooks(){
		return new ResponseEntity<List<Books>>(obj.getAllbooks(),HttpStatus.OK); 
	}
	
	@GetMapping(value="/getbook/{book_id}")
	public ResponseEntity<Books> getBook(@PathVariable("book_id") int id){
		
		return new ResponseEntity<Books>(obj.getBook(id),HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping(value="/update/book/{book_id}")
	public ResponseEntity<Books> updateBook(@PathVariable("book_id") int id,@RequestBody Books book) {
		return new ResponseEntity<Books>(obj.updatebook(id,book.getName(),book.getAuthor(),book.getCategory()),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/delete/book/{book_id}")
		public ResponseEntity<Books> deleteBook(@PathVariable("book_id") int id) {
		 return new ResponseEntity<Books>(obj.deletebook(id),HttpStatus.ACCEPTED);
		}
	
}
