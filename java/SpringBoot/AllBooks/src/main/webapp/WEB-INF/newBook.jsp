<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Book</title>
<link rel="stylesheet" href="css/new.css"/>
</head>
<body>
	<h1>New Book</h1>
	<form action="/processNewBook" method="post" id="main">
		<label for="title">Title:</label>
		<input type="text" name="title"/>
		
		<label for="description">Description:</label>
		<textarea name="description" cols="30" rows="10"></textarea>
		
		<label for="language">Language:</label>
		<input type="text" name="language"/>
		
		<label for="pages">Pages:</label>
		<input type="text" name="pages"/>
		<button>Submit</button>
	</form>
</body>
</html>