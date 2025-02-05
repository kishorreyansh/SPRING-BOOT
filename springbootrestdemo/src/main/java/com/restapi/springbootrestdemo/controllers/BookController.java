package com.restapi.springbootrestdemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbootrestdemo.entities.Book;
import com.restapi.springbootrestdemo.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

    //@RequestMapping(value="/books", method=RequestMethod.GET)
    /*@GetMapping("/books")
    public String getBooks(){
        return "This is  Testing12";
    }*/
	
	//To Get single record
	/*@GetMapping("/books")
    public Book getBooks(){
		Book book = new Book();
		book.setId(01);
		book.setTitle("SPRING BOOT");
		book.setAuthor("REYANSH");
        return book;
    }*/
	
	/*@GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }*/
	
	@GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = this.bookService.getAllBooks();
        if(list.size() <= 0) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
	
	/*@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}*/
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		
		Book book = bookService.getBookById(id);
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	/*@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}*/
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
			b = this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.
					INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int bid) {
		this.bookService.deleteBook(bid);
	}*/
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int bid) {
		try {
			this.bookService.deleteBook(bid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int bid) {
		this.bookService.updateBook(book,bid);
		return book;
	}*/
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, 
			@PathVariable("id") int bid) {
		try {
			this.bookService.updateBook(book,bid);
			return ResponseEntity.ok().body(book);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
