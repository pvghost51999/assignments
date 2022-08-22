package com.library.application.controler;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.library.application.dao.Bookstorerepo;
import com.library.application.entities.BookStore;




@RestController
public class Controler {
//	@Autowired
//	Authentication authentication;
	
	@Autowired
	Bookstorerepo bookrepo;
	
	@RequestMapping("/")
	public String home()
	{
		return "login.jsp";
	}
	
	@PostMapping("/user")
	public ModelAndView login(@RequestParam("user") String username,@RequestParam("pass") String password)
	
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("username", username);
		mv.setViewName("bookdetails.jsp");
		return mv;
	}
	@PostMapping("/add")
	public String adddetails(BookStore bookStore)
	{
		bookrepo.save(bookStore);
		return "bookdetails.jsp";
	}
	
	 
	@GetMapping("/books")
	public List<BookStore> showbooks()
	{
		return bookrepo.findAll();
	}
	
	
	@PostMapping("/books")
	public void addEmployee(@RequestBody BookStore books) {
		
		bookrepo.save(books);
	}
	
	
	@PutMapping("/books/{bcode}")
	public void addEmploysee(@PathVariable String bcode, @RequestBody BookStore books) {
		int id=books.getBcode();
		Optional<BookStore> bookStore=bookrepo.findById(id);
		BookStore b= bookStore.get();
		b.setBname(books.getBname());
		b.setBauthor(books.getBauthor());
		bookrepo.save(b);
	}
	
	
	@DeleteMapping("/books/{bcode}")
	public void delete(@PathVariable String bcode)
	{	int id=Integer.parseInt(bcode);
//		System.out.println("hii");
		bookrepo.deleteById(id);
//		bookrepo.deleteByBcode(id);
		
		
	}


}
