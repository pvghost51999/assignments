<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>

</head>
<body>

	<form action="add" method="post">
		<h4 style="font-weight: bold;">Please Enter Product Details</h4>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Book
				Code</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" placeholder="" name="bcode"
					required="required">
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
				<input type="text" class="form-control" placeholder=""
					name="bauthor" required="required">
			</div>
		</div>
		<div class="form-group row mb-2">
			<label for="inputPassword" class="col-sm-1 col-form-label">Date
				Added</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" placeholder="" name="badddate">
			</div>
		</div>

		<input type="submit" class="btn btn-primary" name="sub"></input>
	</form>
	
</body>
</html>