<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Juego de Piedra, papel o tijera</title>
	
</head>
<body>

	
	<form action="http://localhost:8081/HolaSpringFrameWork/resolverJuego" method="get">	
		<h1>Juego de Piedra, papel o tijera</h1>
		<br>
		<h2>Seleccione una opción</h2>
		<br>
		<select name="selOpcion">
			<c:forEach items="${opciones}" var="opcion">
					<option value="${opcion.getNumero()}">${opcion}</option>
			</c:forEach>
		</select>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>