package com.library.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.library.entities.BookStore;


public class BookdetailDao {
	private List<BookStore> books=new ArrayList<BookStore>();
	public  void display()
	{
	RestTemplate restTemplate = new RestTemplate();
	String Url
	= "http://localhost:8080/books";
	ResponseEntity<BookStore[]> responseEntity
	= restTemplate.getForEntity(Url, BookStore[].class);
	BookStore[] book = responseEntity.getBody();
	 books = Arrays.asList(book);
	}
	public List<BookStore> getBooks() {
		return books;
	}
	public void setBooks(List<BookStore> books) {
		this.books = books;
	}
	
}
