package Ejercicio11;

public class Persona {

	private String nombre;

	private Integer edad;

	public Persona(String nombre, Integer edad) {
		if (nombre == null || nombre.trim().isEmpty()) {
            this.nombre = "Anónimo";
        } else {
            this.nombre = nombre;
        }
        
        // Control de edad
        if (edad < 0) {
            this.edad = 99;
        } else {
            this.edad = edad;
        }
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
