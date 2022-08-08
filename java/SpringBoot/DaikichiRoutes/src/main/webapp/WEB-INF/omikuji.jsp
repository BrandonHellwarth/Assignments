<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form id="main" action="/processOmikuji" method="post">
		<div class="row">
			<label for="number">Pick any number from 5 to 25</label>
			<select name="number" id="num">
				<% for(int i=5;i<=25;i++) { %>
					<option value="<%= i %>"><%= i %></option>
				<% } %>
			</select>
		</div>
		<div class="row">
			<label for="city">Enter the name of your city.</label>
			<input type="text" name="city"/>
		</div>
		<div class="row">
			<label for="person">Enter the name of any real person.</label>
			<input type="text" name="person"/>
		</div>
		<div class="row">
			<label for="hobby">Enter professional endeavor or hobby.</label>
			<input type="text" name="hobby"/>
		</div>
		<div class="row">
			<label for="livingThing">Enter any type of living thing.</label>
			<input type="text" name="livingThing"/>
		</div>
		<div class="row">
			<label for="nice">Say something nice to someone:</label>
			<textarea name="nice" id="nice" cols="30" rows="10"></textarea>
		</div>
		<p>Send and show a friend</p>
		<button>Send</button>
	</form>
</body>
</html>