<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update Gift</title>
</head>
<body>
<form method="post">
<input name="childId" type="hidden" value="${childId}"><br>	
<input name="giftId" type="hidden" value="${gift.id}">
<label for="giftdesc">Gift description:</label><br>
<input name="giftdesc" type="text" value="${ gift.description }"><br>	

<br>
<input type="submit">

</form>
</body>
</html>