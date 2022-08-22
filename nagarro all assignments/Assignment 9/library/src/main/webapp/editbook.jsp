<%@page import="com.library.entities.BookStore"%>
<%@page import="java.util.List"%>
<%@page import="com.library.dao.BookdetailDao"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<% 

if(session.getAttribute("session")==null)
{
	response.sendRedirect("login.jsp");

}
	%>
<form action="edited" method="post">
		<h4 style="font-weight: bold;">Please Enter Product Details</h4>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Book
				Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="" name="bcode"
					required="required" readonly="readonly" value=${bid}>
			</div>
		</div>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Book
				Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="" name="bname"
					required="required">
			</div>
		</div>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Author</label>
			<div class="col-sm-10">
				<select name="bauthor">
				<%
				BookdetailDao books=new BookdetailDao();
				books.display();
				List<BookStore> li=books.getBooks();
				for(BookStore a:li)
				{ %>
				<option value="<%=a.getBauthor() %>"><%=a.getBauthor() %></option>
				
				<%} %>

				</select>
			</div>
		</div>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Date
				Added</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" placeholder="" name="badddate" readonly="readonly" value=${date}>
			</div>
		</div>

		<input type="submit" class="btn btn-primary" name="sub"></input>
		
	</form>
	
	
</body>
</html>