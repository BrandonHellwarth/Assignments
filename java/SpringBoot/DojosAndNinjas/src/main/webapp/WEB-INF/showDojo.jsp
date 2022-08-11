<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${ dojo.name }</title>
</head>
<body>
	<h1>${ dojo.name } Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${ ninjas }">
				<c:choose>
					<c:when test="${ ninja.dojo.id == dojo.id }">
						<tr>
							<td>${ ninja.firstName }</td>
							<td>${ ninja.lastName }</td>
							<td>${ ninja.age }</td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>