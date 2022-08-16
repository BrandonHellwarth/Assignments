<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${ book.title }</title>
</head>
<body>
	<h1>Change your Entry</h1>
	<a href="/books/${ user.id }">back to the shelves</a>
	<form:form action="/processEditBook/${ user.id }/${ book.id }" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${ book.title }"/>
			<form:errors path="title"/>
		</p>
		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author" value="${ book.author }"/>
			<form:errors path="author"/>
		</p>
		<p>
			<form:label path="my_thoughts">My Thoughts:</form:label>
			<form:textarea path="my_thoughts" value="${ book.my_thoughts }"></form:textarea>
			<form:errors path="my_thoughts"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>