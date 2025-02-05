package com.restapi.springbootrestdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.springbootrestdemo.dao.BookRepository;
import com.restapi.springbootrestdemo.entities.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//Get All Books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	//Get Single Book By Id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}
	
	public void deleteBook(int bid) {
		bookRepository.deleteById(bid);
	}
	
	public void updateBook(Book book , int bid) {
		book.setId(bid);
		bookRepository.save(book);
	}
}
