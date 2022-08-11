<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/processNewNinja" method="post" modelAttribute="ninja">
	
		<form:select path="dojo">
			<c:forEach var="dojo" items="${ dojos }">
				<form:option path="dojo" value="${ dojo.id }">${ dojo.name }</form:option>
			</c:forEach>
		</form:select>
		
		<form:errors path="firstName"></form:errors>
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName"></form:input>
		
		<form:errors path="lastName"></form:errors>
		<form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName"></form:input>
		
		<form:errors path="age"></form:errors>
		<form:label path="age">Age:</form:label>
		<form:input path="age"></form:input>
		
		<input type="submit" value="create"/>
	</form:form>
</body>
</html>