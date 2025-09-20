package Ejercicio14;

public class Gerente extends Empleado {

	private int comision = 100;

	public Gerente(String nombreEmpleado, Integer numeroEmpleado, Integer salario, int comision) {
		super(nombreEmpleado, numeroEmpleado, salario);
		this.comision = comision;
	}

	@Override
    public Integer calculaSalario() {
		
		return super.calculaSalario() + comision;
	}
	

}
