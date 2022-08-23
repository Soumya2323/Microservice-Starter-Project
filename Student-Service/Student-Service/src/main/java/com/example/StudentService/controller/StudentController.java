package com.example.StudentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentService.model.Book;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	private BookClient bookClient;
	
	@GetMapping(value = "/allBooks")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		return new ResponseEntity<List<Book>>(bookClient.getAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<Book> getBookbyId(@PathVariable Integer bookId)
	{
		
		return new ResponseEntity<Book>(bookClient.getBookbyId(bookId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/bookByName/{bookName}")
	public ResponseEntity<Book> getBookByName(@PathVariable String bookName)
	{
		return new ResponseEntity<Book>(bookClient.getBookByName(bookName),HttpStatus.OK);
	}
	

}
