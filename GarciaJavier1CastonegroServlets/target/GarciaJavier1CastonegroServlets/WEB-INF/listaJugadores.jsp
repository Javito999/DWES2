<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Asignar rol</title>
</head>
<body>
<h1>Asignar rol a un jugador</h1>

<form action="listaJugadores" method="post">
    <label>Elige jugador:</label>
    <select name="listaJugadores">
        <c:forEach items="${opcionesDesplegable}" var="jugador">
            <option value="${jugador.idJugador}">${jugador.nombre}</option>
        </c:forEach>
    </select>
    <button type="submit">Asignar rol</button>
</form>

<c:if test="${not empty rol}">
    <h3>Jugador: ${nombreJugador}</h3>
    <h3>Rol asignado: ${rol}</h3>
    <p>${mensaje}</p>
</c:if>
</body>
</html>
