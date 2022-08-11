<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${ expenses }">
				<tr>
					<td><a href="/expenses/${ expense.id }"><c:out value="${ expense.name }"/></a></td>
					<td><c:out value="${ expense.vendor }"/></td>
					<td><c:out value="${ expense.amount }"/></td>
					<td><a href="/expenses/edit/${ expense.id }">edit</a></td>
					<td>
						<form action="/expenses/delete/${ expense.id }" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Add an Expense:</h1>
	<form:form action="/processNewExpense" method="post" modelAttribute="expense">
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
			<<form:textarea path="description"></form:textarea>
			<form:errors path="description"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>