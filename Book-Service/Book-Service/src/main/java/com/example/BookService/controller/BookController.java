package com.example.BookService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookService.model.Book;
import com.example.BookService.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	@PostMapping(value = "/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/allBooks")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(),HttpStatus.OK);
	}
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<Book> getBookbyId(@PathVariable Integer bookId)
	{
		return new ResponseEntity<Book>(bookService.getBookbyId(bookId),HttpStatus.OK);
	}
	@GetMapping(value = "/name/{bookName}")
	public ResponseEntity<Book> getBookbyName(@PathVariable String bookName)
	{
		return new ResponseEntity<Book>(bookService.getBookByName(bookName),HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable int id)
	{
		return new ResponseEntity<String>(bookService.deleteById(id),HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book)
	{
		return new ResponseEntity<Book>(bookService.updateBook(id,book),HttpStatus.OK);
	}
	
	


}
