package Ejercicio12;

public class Persona {

	private String nombre;

	private Integer edad;

	public Persona(String nombre, String edadStr) {

		if (nombre != null && !nombre.trim().isEmpty()) {
			this.nombre = nombre;
		}
		// Si nombre está vacío o null, no se inicializa (queda null)

		// Control de edad
		if (edadStr != null && !edadStr.trim().isEmpty()) {
			try {
				int edadInt = Integer.parseInt(edadStr.trim());
				if (edadInt >= 0) {
					this.edad = edadInt;
				}
				// Si edad es negativa, no se inicializa (queda null)
			} catch (NumberFormatException e) {
				// Si no es un número válido, no se inicializa (queda null)
			}
		}
		// Si edad está vacía o null, no se inicializa (queda null)
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public String toString() {
		return "nombre='" + nombre + "', edad=" + edad + "";
	}

}
