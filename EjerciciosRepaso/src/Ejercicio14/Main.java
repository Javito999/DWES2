package Ejercicio14;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Empleado> listaEmpleados = new ArrayList<>();

		listaEmpleados.add(new Gerente("federico", 1, 1200, 200));
		listaEmpleados.add(new Trabajador("paco", 2, 1300));
		listaEmpleados.add(new TrabajadorHoras("cristina", 3, 1400, 100));

		for (Empleado emp : listaEmpleados) {

			System.out.println(emp.getNombreEmpleado() + " cobra " + emp.calculaSalario());
		}

	}

}
