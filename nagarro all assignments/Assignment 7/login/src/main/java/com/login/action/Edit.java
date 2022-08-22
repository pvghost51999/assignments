package com.login.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.login.Application.UserProduct;
import com.login.session.HibernateUtility;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class Edit extends HttpServlet 
{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		Session sess=HibernateUtility.getSessionFactory().getCurrentSession();
		String title=request.getParameter("title");
//		String image=request.getParameter("image");
		String quantity=request.getParameter("quantity");
		int  size=Integer.parseInt(request.getParameter("size"));
//		FileInputStream fis=new FileInputStream(image);
//		byte[] data=new byte[fis.available()];
//		fis.read(data);
		int pid=(Integer) session.getAttribute("pid");
		System.out.println(pid);
//		String str="update UserProduct set name= where sno=165";
		Transaction tx=sess.beginTransaction();
		TypedQuery t1=sess.createQuery("update UserProduct set name=:n,quantity=:qua, size=:si where sno=:v");
		t1.setParameter("n", title);
		t1.setParameter("qua", quantity);
		t1.setParameter("si", size);
		t1.setParameter("v", pid);
		t1.executeUpdate();
		tx.commit();
		response.sendRedirect("product.jsp");
		
//		UPDATE Customers
//		SET ContactName='Alfred Schmidt', City='Frankfurt'
//		WHERE CustomerID=1;
//		+",quantity="+quantity+",size="+size+" 
	}


}
