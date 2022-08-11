<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go Back</a>
	<form:form action="/processEditExpense/${ expense.id }" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put"><!-- not sure what this does?-->
		<p>
			<form:label path="name">Expense Name:</form:label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:input path="vendor"/>
			<form:errors path="vendor"/>
		</p>
		<p>
			<form:label path="amount">Amount:</form:label>
			<form:input path="amount"/>
			<form:errors path="amount"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>