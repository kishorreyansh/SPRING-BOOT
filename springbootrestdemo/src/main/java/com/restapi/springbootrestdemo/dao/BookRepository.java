package com.restapi.springbootrestdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.springbootrestdemo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	public Book findById(int id);
}
