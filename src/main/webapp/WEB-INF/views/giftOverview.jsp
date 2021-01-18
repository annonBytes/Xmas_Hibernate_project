<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gift overview</title>
<style>
table, td {border: 1px solid black}
</style>
</head>
<body>
<c:choose>
<c:when test="${empty children}">
<p>No entries available.</p>
</c:when>
<c:otherwise>
<table>
	<thead>
		<tr>
			<th>giftId</th>
			<th>giftName</th>
			<th>childId</th>
			<th>childName</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="child" items='${children}'>
			<c:forEach var="gift" items='${child.gifts}'>
				<tr>
				<td>${gift.id}</td>
				<td>${gift.description}</td>
				<td>${child.id}</td>
				<td>${child.name}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>
<br>
<form action="list">
    <input type="submit" value="return to list" />
</form>

</body>
</html>