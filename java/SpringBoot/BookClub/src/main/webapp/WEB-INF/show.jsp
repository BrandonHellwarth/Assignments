<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${ book.title }</title>
</head>
<body>
	<h1>${ book.title }</h1>
	<a href="/books/${ user.id }">back to the shelves</a>
	<c:choose>
		<c:when test="${ book.user.id == user.id }">
			<p>${ user.userName } read ${ book.title } by ${ book.author }.</p>
			<p>Here are ${ user.userName }'s thoughts:</p>
		</c:when>
		<c:otherwise>
			<p>${ book.title } by ${ book.author }</p>
		</c:otherwise>
	</c:choose>
	<p>${ book.my_thoughts }</p>
	<c:choose>
		<c:when test="${ book.user.id == user.id }">
			<a href="/books/edit/${ user.id }/${ book.id }">Edit</a>
		</c:when>
	</c:choose>
</body>
</html>