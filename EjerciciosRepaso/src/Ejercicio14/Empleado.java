package Ejercicio14;

public class Empleado {

	
	private String nombreEmpleado;
	
	private Integer numeroEmpleado;
	
	private Integer salario;

	public Empleado(String nombreEmpleado, Integer numeroEmpleado, Integer salario) {
		super();
		this.nombreEmpleado = nombreEmpleado;
		this.numeroEmpleado = numeroEmpleado;
		this.salario = salario;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombreEmpleado=" + nombreEmpleado + ", numeroEmpleado=" + numeroEmpleado + ", salario="
				+ salario + "]";
	}
	
	public Integer calculaSalario() {
		
		return salario;
	}
	
	
}
