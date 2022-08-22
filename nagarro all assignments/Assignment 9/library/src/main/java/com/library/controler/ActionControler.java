package com.library.controler;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.library.entities.BookStore;

@Controller
public class ActionControler {
	
	@PostMapping("/edit")
	public ModelAndView edit(@RequestParam("bid") String bid,@RequestParam("date") String date)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("bid",bid);
		mv.addObject("date",date);
		mv.setViewName("editbook.jsp");
		return mv;	
	}
	
	@PostMapping("/edited")
	public String edited(BookStore bookStore)
	{	String bcode=Integer.toString(bookStore.getBcode());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookStore> requestEntity = new HttpEntity<>(bookStore, headers);
		RestTemplate restTemplate = new RestTemplate();
		String Url
		= "http://localhost:8080/books/";
		ResponseEntity<BookStore> responseEntity = restTemplate.exchange(Url+bcode,HttpMethod.PUT ,requestEntity, BookStore.class);
	
		return"bookdetails.jsp";
	}
	
	
	@PostMapping("delete")
	public String delete(@RequestParam("bid") String bcode)
	{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<>(bcode, headers);
		RestTemplate restTemplate = new RestTemplate();
		String Url
		= "http://localhost:8080/books/";
		ResponseEntity<BookStore> responseEntity = restTemplate.exchange(Url+bcode,HttpMethod.DELETE ,requestEntity, BookStore.class);
	
		return"bookdetails.jsp";
		
	}
}
