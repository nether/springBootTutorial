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
<h1>Gestión de empleados</h1>

<!-- Formulario -->
<p>
<form method="post" action="/empleados">
	<table>
	<tr><td>Cif:</td><td><input type="text" name="cif" value="${empleadoAMostrar.cif}"/></td></tr>
	<tr><td>Nombre:</td><td><input type="text" name="nombre" value="${empleadoAMostrar.nombre}"/></td></tr>
	<tr><td>Apellidos:</td><td><input type="text" name="apellidos" value="${empleadoAMostrar.apellidos}"/></td></tr>
	<tr><td>Edad:</td><td><input type="text" name="edad" value="${empleadoAMostrar.edad}"/></td></tr>	
	</table></br></br>
	
	<input type="submit" value="Listar" name="listar"/>
	<input type="submit" value="Mostrar Uno" name="getOne"/>
	<input type="submit" value="Insertar" name="insertar"/>
	<input type="submit" value="Modificar" name="modificar"/>
	<input type="submit" value="Eliminar" name="eliminar"/>
</form>
</p>

<p>
		<table>
			<tr><th>Cif</th><th>Nombre</th><th>Apellidos</th><th>Edad</th></tr>
			<c:forEach items="${listaEmpleados}" var="empleado">
				<tr>
					<td>${empleado.cif}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.apellidos}</td>
					<td>${empleado.edad}</td>
				</tr>
			</c:forEach>
		</table>
</p>
<p>
${mensaje}
</p></body>
</html>