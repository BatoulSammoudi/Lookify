<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new Song</title>
</head>
<body>
	<h1>New Song</h1>
	<form:form action="/start" method="post" modelAttribute="song">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="rating">Rating(1-10)</form:label>
			<form:errors path="rating" />
			<form:input type="number" path="rating" />
		</p>
		<p>
			<form:label path="artist">Artist</form:label>
			<form:errors path="artist" />
			<form:input path="artist" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
	<a href="">Delete</a>
</body>
</html>