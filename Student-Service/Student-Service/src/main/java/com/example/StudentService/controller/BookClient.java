package com.example.StudentService.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.StudentService.model.Book;

@FeignClient(name = "BOOK-SERVICE" , url = "http://localhost:8081/")
public interface BookClient {
	@GetMapping(value = "/book/allBooks")
	public List<Book> getAllBooks();
	
	@GetMapping(value = "/book/{bookId}")
	public Book getBookbyId(@PathVariable Integer bookId);
	
	@GetMapping(value = "/book/name/{bookName}")
	public Book getBookByName(@PathVariable String bookName);

}
