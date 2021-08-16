<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="ISO-8859-1">
   <title>Insert title here</title>
</head>
<body>
<a href="/start">Dashboard</a>
<h1>Songs for <c:out value="${artist}"></c:out></h1>
 <table>
		<thead>
			<tr>
				<th>Title</th>
				<th>rating</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/Song/${song.id}"><c:out value="${song.title}" /></a></td>
					<td><c:out value="${song.rating}" /></td>
					<td><form action="/songs/${song.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>