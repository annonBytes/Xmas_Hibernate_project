<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>children list</title>
<style>
table, td {border: 1px solid black}
</style>
</head>

<body bgcolor="#FFFFFF" text="#000000">
<h1>List of Children</h1>

<form method="get">
<c:choose>
<c:when test="${empty children}">
<p>No entries available.</p>
</c:when>
<c:otherwise>
<table>
<c:forEach var="child" items='${children}'>
<tr>
<td><input type="radio" name="entryId" value="${child.id}"></td>
<td>${child.id}</td>
<td><a href="${pageContext.request.contextPath}/xmas/childDetail?id=${child.id}"><c:out value="${child.name}" escapeXml="true" /></a></td>
<td>${child.gifts.size()}</td>
</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
<p>
<input type="button" value="New" onClick="this.form.action='addChild';submit()">
<input type="button" value="Delete" onClick="this.form.action='deleteChild';submit()">
<input type="button" value="Update" onClick="this.form.action='updateChild';submit()">

</form>

<br><br>

<form action="giftOverview">
    <input type="submit" value="go to giftOverview" />
</form>

</body>
</html>