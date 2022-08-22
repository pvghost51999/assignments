<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nagarro-Login or Sign up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="login.css">
</head>

<style>
 <%@include file="style/login.css"%>
</style>
<body>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>
    <main>
        <div class="row">
            <div class="colm-logo col-lg-6 col-12 col-md-6">
                <img src="https://upload.wikimedia.org/wikipedia/en/1/17/Nagarro_Logo.png" alt="Logo">
               
            </div>
            <div class="colm-form col-lg-6 col-12 col-md-lg">
                <div class="form-container">
                <form action="user" method="post">
                    <input type="text" placeholder="Usename"  name="user"></input>
                    <input type="password" placeholder="Password" name="pass"></input>
                    <input type="submit"  class="btn-login" name="loginbtn" value="Login"></input>
                    </form>
                    <a href="#">Forgotten password?</a>
                    <button class="btn-new">Create new Account</button>
                </div>
                <p><a href="#"><b>Library Management</b></a> holds the book records.</p>
            </div>
        </div>
    </main>
    <footer>
        <div class="footer-contents">
            <ol>
                <li>English (UK)</li>
                <li><a href="#">മലയാളം</a></li>
                <li><a href="#">தமிழ்</a></li>
                <li><a href="#">తెలుగు</a></li>
                <li><a href="#">বাংলা</a></li>
                <li><a href="#">اردو</a></li>
                <li><a href="#">हिन्दी</a></li>
                <li><a href="#">ಕನ್ನಡ</a></li>
                <li><a href="#">Español</a></li>
                <li><a href="#">Português (Brasil)</a></li>
                <li><a href="#">Français (France)</a></li>
                <li><button>+</button></li>
            </ol>
        </div>
    </footer>
</body>
</html>
