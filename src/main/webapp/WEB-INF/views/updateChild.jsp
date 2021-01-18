<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update children</title>
</head>
<body>
<form method="post">
<input name="id" type="hidden" value="${ child.id }"><br>	
 

<label for="childname">Name:</label><br>
<input name="childname" type="text" value="${ child.name }"><br>	

<br>
<input type="submit">

</form>
</body>
</html>