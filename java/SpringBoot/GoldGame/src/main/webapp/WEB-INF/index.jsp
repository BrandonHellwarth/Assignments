<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gold Game</title>
</head>
<body>
	<div id="header">
		<h2>Your Gold:</h2>
		<p><c:out value="${ gold }"/></p>
	</div>
	<div id="main">
		<form action="/processAdd" method="post">
			<input type="hidden" name="hid" value="0"/>
			<h3>Farm</h3>
			<p>(Earns 10-20 gold)</p>
			<button>Find Gold!</button>
		</form>
		<form action="/processAdd" method="post">
			<input type="hidden" name="hid" value="1"/>
			<h3>Cave</h3>
			<p>(Earns 5-10 gold)</p>
			<button>Find Gold!</button>
		</form>
		<form action="/processAdd" method="post">
			<input type="hidden" name="hid" value="2"/>
			<h3>House</h3>
			<p>(Earns 2-5 gold)</p>
			<button>Find Gold!</button>
		</form>
		<form action="/processQuest" method="post">
			<h3>Quest</h3>
			<p>(Earns/takes 0-50 gold)</p>
			<button>Find Gold!</button>
		</form>
	</div>
	<h2>Activities:</h2>
	<div id="lower">
	</div>
</body>
</html>