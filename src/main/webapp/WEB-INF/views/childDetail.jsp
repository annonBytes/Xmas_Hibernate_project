<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>child detail</title>
<style>
table, td {border: 1px solid black}
</style>
</head>
<body>

<strong>${child.name}</strong>
<form method="post">
<input type="hidden" name="childId" value="${child.id}">
<input type="hidden" name="addressId" value="${child.address.id}">
<input type="text" name="address" value="${child.address.text}">
<input type="button" value="Update" onClick="this.form.action='updateAddress';submit()">
</form>
<br>


<p> gifts: </p>
<table>

<form method="get">
<input type="hidden" name="childId" value="${child.id}">
<c:forEach var="gift" items='${child.gifts}'>
	<tr>
	<td><input type="radio" name="giftId" value="${gift.id}"></td>
	<td>${gift.id}</td>
	<td>${gift.description}</td>
	</tr>
</c:forEach>

</table>

<input type="button" value="New" onClick="this.form.action='addGift';submit()">
<input type="button" value="Delete" onClick="this.form.action='deleteGift';submit()">
<input type="button" value="Update" onClick="this.form.action='updateGift';submit()">
</form>

<br><br>

<form action="list">
    <input type="submit" value="return to list" />
</form>
</body>
</html>