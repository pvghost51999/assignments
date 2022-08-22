package com.library.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogoutControler {
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletRequest response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/login.jsp";
	}
}
