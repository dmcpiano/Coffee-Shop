<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>

		<h1>Add Items</h1>
		
		<form method="post">
	<p>name: <input type="text" name= "name" required/> </p>
	<p>description: <input type="text" name= "description" required/> </p>
	<p> price: <input type="number" name= "price" required/> </p>
	<p><input type="submit"/></p>
</form>
<a href="/">Home</a>
</body>
</html>