<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coffee Shop App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<span>Current User: ${preference.yourname }</span>
<br>
<a href="/admin">Admin Page</a>



<h1>Welcome to the Coffee Shop App</h1>
<h2> Menu</h2>
<table class="table">

			<thead>
				<tr>
				<th>Name</th><th>Description</th><th>Price</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="Products" items="${products}">
				<tr>
					<td><a href="/index?id=${Products.id}">${Products.name}</a></td>
					<td>${Products.description}</td>
					<td> $${Products.price}</td>
				</tr>
			</c:forEach>
				<c:if test="${ empty preference.yourname }">
			<a href="/login">Log in</a>
			
		</c:if>
		<c:if test="${ not empty preference.yourname }">
		<br>
			Welcome ${ preference.yourname }!
			<br>
			<a href="/logout">Log out</a>
		</c:if>
			</tbody>
		</table>
		
		<p> <a href="/register">Go</a></p>

</body>
</html>