<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>web de empleados que utiliza microservicios</title>
</head>
<body>
<p>
<a href="empleados">App de empleados</a>
</p>
<p>
<form:form action="logout">
<input type="submit" value="Logout" />
</form:form>
</p>
</body>
</html>