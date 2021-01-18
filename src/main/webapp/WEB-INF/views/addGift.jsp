<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add Gift</title>
</head>
<body>
<form method="post">

<input name="childId" type="hidden" value="${childId}"><br>	
<label for="giftdesc">Gift description:</label><br>
<input name="giftdesc" type="text"><br>	

<br>
<input type="submit">

</form>
</body>
</html>