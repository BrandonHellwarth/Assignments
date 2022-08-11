<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/processNewDojo" method="post" modelAttribute="dojo">
		<form:errors path="name"></form:errors>
		<form:label path="name">Name:</form:label>
		<form:input path="name"></form:input>
		<input type="submit" value="create"/>
	</form:form>
</body>
</html>