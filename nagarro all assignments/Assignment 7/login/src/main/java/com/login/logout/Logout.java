package com.login.logout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hiiii");
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("LoginPage.jsp");
	}
}
