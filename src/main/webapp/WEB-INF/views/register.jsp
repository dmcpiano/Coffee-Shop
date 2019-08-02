<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
</head>
<body>
<h1>Register</h1>
<form action="/register-result" method="post">
	<p>UserName: <input type="text" name= "username" required/> </p>
	<p>Password: <input type="password" name= "password" required/> </p>
	<p> Your Name: <input type="text" name= "yourname" required/> </p>
	<p><input type="submit"/></p>
</form>
<a href="/">Home</a>
</body>
</html>