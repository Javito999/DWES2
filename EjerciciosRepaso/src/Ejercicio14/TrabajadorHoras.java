package Ejercicio14;

public class TrabajadorHoras extends Empleado {
	
	private int horasExtra;

	public TrabajadorHoras(String nombreEmpleado, Integer numeroEmpleado, Integer salario, int horasExtra) {
		super(nombreEmpleado, numeroEmpleado, salario);
		this.horasExtra = horasExtra;
	}
	
	// asumimos que la hora extra son 10 euros la hora.
	@Override
	public Integer calculaSalario() {
		
		return super.calculaSalario() + horasExtra*10;
	}

	public Integer salarioTrabajadorHorasExtra() {
		
		return calculaSalario();
	}
	
}
