package com.example.BookService.service;

import java.util.List;
import java.util.Optional;

import com.example.BookService.model.Book;

public interface BookService {
	Book saveBook(Book book);
	List<Book>getAllBooks();
	Book getBookbyId(int bookId);
	Book getBookByName(String bookName);
	
	String deleteById(int id);
	Book updateBook(int id, Book book);
	

}
