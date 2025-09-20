package Ejercicio13;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Crear lista de cuentas
				ArrayList<Cuenta> cuentas = new ArrayList<>();

				// Crear cuentas corrientes
				cuentas.add(new CuentaCorriente(1001, 0));
				cuentas.add(new CuentaCorriente(1002, 0));
				cuentas.add(new CuentaCorriente(1003, 0));

				// Crear cuentas de ahorro
				cuentas.add(new CuentaAhorro(2001, 0));
				cuentas.add(new CuentaAhorro(2002, 0));
				cuentas.add(new CuentaAhorro(2003, 0));

				System.out.println("=== ESTADO INICIAL DE LAS CUENTAS ===");
				for (Cuenta cuenta : cuentas) {
					System.out.println(cuenta);
				}

				// Ingresar algo de dinero en algunas cuentas para la prueba
				System.out.println("\n=== INGRESANDO DINERO ===");
				cuentas.get(0).ingresarDinero(100); // Cuenta corriente
				cuentas.get(3).ingresarDinero(50); // Cuenta ahorro
				cuentas.get(4).ingresarDinero(75); // Cuenta ahorro

				System.out.println("\n=== ESTADO DESPUÉS DE INGRESOS ===");
				for (Cuenta cuenta : cuentas) {
					System.out.println(cuenta);
				}

				// Probar polimorfismo - retirar dinero de todas las cuentas
				System.out.println("\n=== PROBANDO POLIMORFISMO - RETIRAR DINERO ===");

				for (Cuenta cuenta : cuentas) {
					System.out.println("\nIntentando retirar 30€ de " + cuenta.getClass().getSimpleName() + " "
							+ cuenta.getCuentaNumber());
					cuenta.sacarDinero(30); // Llamada polimórfica
				}

				System.out.println("\n=== ESTADO FINAL DE LAS CUENTAS ===");
				for (Cuenta cuenta : cuentas) {
					System.out.println(cuenta);
				}

				// Demostrar diferencias entre tipos de cuenta
				System.out.println("\n=== DEMOSTRACIÓN ADICIONAL ===");
				System.out.println("Intentando retirar 200€ de cada tipo de cuenta:");

				CuentaCorriente cc = new CuentaCorriente(9999, 0);
				CuentaAhorro ca = new CuentaAhorro(8888, 0);

				cc.ingresarDinero(50);
				ca.ingresarDinero(50);

				System.out.println("\nAntes de retirar 200€:");
				System.out.println(cc);
				System.out.println(ca);

				System.out.println("\nRetirando 200€:");
				cc.sacarDinero(200); // Permitirá saldo negativo
				ca.sacarDinero(200); // NO permitirá saldo negativo

				System.out.println("\nDespués de intentar retirar 200€:");
				System.out.println(cc);
				System.out.println(ca);
			}

}
