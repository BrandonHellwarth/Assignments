<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome, ${ user.userName }</h1>
	<p>Books from everyone's shelves:</p>
	<a href="/logout">logout</a>
	<a href="/books/new/${ user.id }">+ Add a book to my shelf!</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${ books }">
				<tr>
					<td>${ book.id }</td>
					<td><a href="/books/show/${ user.id }/${ book.id }">${ book.title }</a></td>
					<td>${ book.author }</td>
					<td>${ book.user.userName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>