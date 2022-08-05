<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<div id="main">
		<div class = row>
			<h4>Name</h4>
			<h4>Price</h4>
		</div>
		<c:forEach var="fruit" items="${fruitsFromController}">
			<div class = row>
				<p><c:out value="${fruit.name}"/></p>
				<p><c:out value="${fruit.price}"/></p>
			</div>
		</c:forEach>
	</div>
</body>
</html>