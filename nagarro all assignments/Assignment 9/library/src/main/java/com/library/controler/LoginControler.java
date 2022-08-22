package com.library.controler;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpEntity;


import com.library.entities.BookStore;
import com.library.service.Authentication;

@Controller
public class LoginControler {
	@Autowired
	Authentication authentication;
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	HttpSession httpSession;
	
	@PostMapping("/user")
	public ModelAndView login(@RequestParam("user") String username,@RequestParam("pass") String password,HttpServletRequest request,HttpServletResponse response)
	
	{
		Session sess=hibernateTemplate.getSessionFactory().openSession();
		httpSession=request.getSession();
		httpSession.setAttribute("session", sess);
		ModelAndView mv=new ModelAndView();
		mv.addObject("username", username);
		mv.addObject("sess", sess);
		request.setAttribute("sess",sess);
		mv.setViewName("bookdetails.jsp");
		System.out.println(sess);
		if(authentication.validate(username, password))
		{
			
		return mv;
		}
		else {
			mv.setViewName("login.jsp");
			return mv;
		}
	}
	
	
	@PostMapping("/books")
	public String create( BookStore bookStore)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BookStore> requestEntity = new HttpEntity<>(bookStore, headers);
		RestTemplate restTemplate = new RestTemplate();
		String Url
		= "http://localhost:8080/books";
		ResponseEntity<BookStore> responseEntity = restTemplate.postForEntity(Url, requestEntity, BookStore.class);
	
		return"bookdetails.jsp";
	}
	
	
}
