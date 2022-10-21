<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de empleados</title>
</head>
<body>
<h1>Gestión de Departamentos</h1>

<!-- Formulario -->
<p>
</p>

<p>
	<c:forEach items="${listaDepartamentos}" var="departamento">
	<h2>${departamento.id}</h2>
		<table>	
			<tr><th>Cif</th><th>Nombre</th><th>Apellidos</th><th>Edad</th></tr>
			<c:forEach items="${departamento.empleados}" var="empleado">
				<tr>
					<td>${empleado.cif}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.apellidos}</td>
					<td>${empleado.edad}</td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
</p>
<p>
${mensaje}
</p></body>
</html>