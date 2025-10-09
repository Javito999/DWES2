<html>
<body>

<!--Este será el endpoint que atienda la petición cuando se pulse “Enviar”.
Tendremos que crear un servlet mapeado a esta dirección -->
<form action="http://localhost:8080/saludo/Hola" method="post"> <!-- El método
http usado será “post” dado que es un formulario y queremos que los datos vayan
en el body -->
<label for="nombre">Pulsa aquí paa obtener un número aleatorio: </label>
<br/>
<br/>
<input type="submit" id="Enviar" value="Enviar" />
</form>
</body>
</html>