<%@page import="org.hibernate.Session"%>
<%@page import="com.library.dao.BookdetailDao"%>
<%@page import="org.springframework.web.bind.annotation.PostMapping"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.http.ResponseEntity"%>
<%@page import="com.library.entities.BookStore"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Objects"%>
<%@page import="org.springframework.web.client.RestTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	type="text/javascript"></script>
<title>Insert title here</title>

</head>
<style type="text/css">
<style>
 <%@include file="style/bookdetails.css"%>
</style>


<body>
<% 

if(session.getAttribute("session")==null)
{	
	response.sendRedirect("login.jsp");

}
	%>
	<nav class="navbar navbar-inverse row">
		<div class="col-lg-7 header ml-3">
			<div class="navbar-header ">
			
			</div>
		</div>
		<div class="col-lg-5 logout d-flex justify-content-end ">
			<form action="logout" method="get" class="d-flex">
			<h4 style="color: white; text-align: left; margin-right: 3%">Welcome ${username}</h4>
				<input type="submit" class="btn btn-danger mr-3 ml-2" value="Logout"></input>
			</form>
		</div>

	</nav>
	<div class="row sec">
		<div class="col-lg-7 d-flex justify-content-end">
			<h1>Books Listing</h1>
		</div>

		<div class="col-lg-5 d-flex justify-content-end align-items-center">
			<form action="addbook" method="post">
				<input type="submit" value="Add a book" class="btn btn-primary"></input>
			</form>
		</div>

	</div>
	<table class="w3-table-all">
		<thead>
			<tr class="w3-green">
				<th>Book Code</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Date Added</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
		try {
			BookdetailDao bdao = new BookdetailDao();
			bdao.display();
			List<BookStore> books = bdao.getBooks();

			for (BookStore b : books) {
		%>
		<tr>
			<td><%=b.getBcode()%></td>
			<td><%=b.getBname()%></td>
			<td><%=b.getBauthor()%></td>
			<td><%=b.getBadddate()%></td>
			<td>
				<div class="row">
					<div class="col-lg-6 but" style="width:fit-content;">
						<form action="edit" method="post">
							<input type="hidden" value="<%=b.getBcode()%>" name="bid"></input>
							<input type="hidden" value="<%=b.getBadddate()%>" name="date"></input>
							<input type="submit" class="btn btn-primary mb-3" value="Edit"></input>
						</form>
					</div>
					<div class="col-lg-6 but" style="width:fit-content;">
						<form action="delete" method="post">
							<input type="hidden" value="<%=b.getBcode()%>" name="bid"></input>
							<input type="submit" class="btn btn-danger" value="Delete"></input>
						</form>
					</div>
				</div>
			</td>
		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>

		<td></td>
	</table>
</body>
</html>