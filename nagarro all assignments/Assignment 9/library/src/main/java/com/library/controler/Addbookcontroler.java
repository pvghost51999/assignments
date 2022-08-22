package com.library.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Addbookcontroler {

	@PostMapping("/addbook")
	public String addbook()
	{	
		return "addbook.jsp";
	}
	
}
