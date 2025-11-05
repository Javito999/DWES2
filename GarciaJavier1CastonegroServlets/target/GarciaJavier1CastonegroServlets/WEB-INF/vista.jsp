<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listaJugadores</title>
</head>
<body>
<h1>Asignar rol a un jugador</h1>
<select name='listaJugadores'>
	<c:forEach items="${opcionesDesplegable}" var="jugador">
		<option value="${jugador.id}">${jugador.nombre}</option>
	</c:forEach>
</select>
<button>Asignar rol</button>

</body>
</html>