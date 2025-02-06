package com.restapi.springbootrestdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.springbootrestdemo.entities.Book;

//Dummy Service
@Component
public class BookServiceStandAlone {

	private static List<Book> list = new ArrayList<>();
	
	static {
		//list.add(new Book(02,"JAVA","Ridhansh"));
		//list.add(new Book(03,"React","Salaar"));
	}
	
	//Get All Books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//Get Single Book By Id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	public void deleteBook(int bid) {
		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
	}
	
	public void updateBook(Book book , int bid) {
		list = list.stream().map(b -> {
			if(b.getId() == bid) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
}
