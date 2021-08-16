<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Insert title here</title>
</head>
<body>
 <h1><c:out value="${ song.title}"></c:out></h1>
 <p>Artist :<c:out value="${ song.artist} "></c:out></p>
 <p>Rating : <c:out value="${ song.rating }"></c:out></p>
</body>
</html>