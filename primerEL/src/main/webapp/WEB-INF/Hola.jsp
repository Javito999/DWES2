<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hola, ${persona.nombre } y tienes ${persona.edad }

el equipo en la posicion  1 del array es: ${listaEquipos[1]}
el equipo en la posicion 2 del array es: ${listaEquipos[2].nombre}
</body>
</html>