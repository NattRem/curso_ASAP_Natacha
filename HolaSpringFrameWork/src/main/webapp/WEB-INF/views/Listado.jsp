<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${titulo}</title>


</head>
<body>
<h1>PROFESOR ${profesor}</h1>
<br>

	<table>
	<tr>
	<th>codigo</th><th>nombre</th><th>apellido</th><th>repositorio</th>
	</tr>
		<c:forEach items="${alumnos}" var="alumno">
			<tr>
				<td><c:out value="${alumno.getCodigo()}"/>  </td>
				<td><c:out value="${alumno.getNombre()}"/>  </td>
				<td><c:out value="${alumno.getApellido()}"/></td>
				<td><c:out value="${alumno.getLinkArepositorio()}"/></td> 
			</tr>
		</c:forEach>
	</table>


</body>
</html>