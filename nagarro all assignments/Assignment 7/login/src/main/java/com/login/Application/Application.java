package com.login.Application;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;
import org.hibernate.Session;


import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.login.validateusername.*;

@WebServlet("/check")
public class Application extends HttpServlet {

		public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
		{
			String username=request.getParameter("user");
			String password =request.getParameter("pass");
			 Session sess=ValidateUsername.fetch(username,password);
//			 System.out.println(sess);
			HttpSession session=request.getSession();
			
			
			if(sess!=null)
			{
				session.setAttribute("arg",sess);
				session.setAttribute("username", username);
				response.sendRedirect("product.jsp");
			}
			else {
				PrintWriter out =response.getWriter();
				out.println("Wrong Password");
			}
			
		}

}
