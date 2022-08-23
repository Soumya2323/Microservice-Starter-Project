package com.example.BookService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookService.exception.ResourseNotFoundException;
import com.example.BookService.model.Book;
import com.example.BookService.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookbyId(int bookId) {
		Book book=bookRepository.findById(bookId)
				.orElseThrow(() ->new ResourseNotFoundException("Book not exist with id "+bookId));
		return bookRepository.findById(bookId).get();
	}

	@Override
	public Book getBookByName(String bookName) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookName(bookName);
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		Book book=bookRepository.findById(id).orElseThrow(() ->new ResourseNotFoundException("Book not exist with id "+id));
		bookRepository.deleteById(id);
		return "Succesfully Deleted the Book with id "+id;
	}

	@Override
	public Book updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		Book book2=bookRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Book with id "+id +" not exist."));
		book2.setBookName(book.getBookName());
		book2.setBookPrice(book.getBookPrice());
		
		return bookRepository.save(book2);
	}

	

}
