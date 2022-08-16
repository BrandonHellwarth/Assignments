<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book</title>
</head>
<body>
	<h1>Add a Book to your Shelf!</h1>
	<a href="/books/${ user.id }">Back to the Shelves</a>
	<form:form action="/processNewBook/${ user.id }" method="post" modelAttribute="book">
			<form:input type="hidden" path="user" value="${ user.id }"></form:input>
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title"/>
			<form:errors path="title"/>
		</p>
		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author"/>
			<form:errors path="author"/>
		</p>
		<p>
			<form:label path="my_thoughts">My Thoughts:</form:label>
			<form:textarea path="my_thoughts"></form:textarea>
			<form:errors path="my_thoughts"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>