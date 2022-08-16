<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register</title>
</head>
<body>
	<h1>Book Club</h1>
	<p>A place for friends to share thoughts on books.</p>
	<div id="main">
		<form:form action="/processRegister" method="post" modelAttribute="user" id="left">
			<h2>Register</h2>
			<form:label path="userName">User Name:</form:label>
			<form:input path="userName"></form:input>
			<form:errors path="userName"></form:errors>
			
			<form:label path="email">Email:</form:label>
			<form:input path="email"></form:input>
			<form:errors path="email"></form:errors>
			
			<form:label path="password">Password:</form:label>
			<form:input path="password"></form:input>
			<form:errors path="password"></form:errors>
			
			<form:label path="confirm">Confirm Password:</form:label>
			<form:input path="confirm"></form:input>
			<form:errors path="confirm"></form:errors>
			<input type="submit" value="submit"/>
		</form:form>
		<form:form action="/processLogin" method="post" modelAttribute="userLogin" id="right">
			<h2>Login</h2>
			<form:label path="email">Email:</form:label>
			<form:input path="email"></form:input>
			<form:errors path="email"></form:errors>
			
			<form:label path="password">Password:</form:label>
			<form:input path="password"></form:input>
			<form:errors path="password"></form:errors>
			<input type="submit" value="submit"/>
		</form:form>
	</div>
</body>
</html>