package Ejercicio11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Persona> listaPersonas = new ArrayList<>();

		System.out.println("Introductor de personas (escribe 'salir' para terminar)");

		while (true) {
			System.out.print("Introduce nombre: ");
			String nombre = sc.nextLine();

			if (nombre.equalsIgnoreCase("salir")) {
				break;
			}

			System.out.print("Introduce edad: ");
			int edad = sc.nextInt();

			Persona persona = new Persona(nombre, edad);
			listaPersonas.add(persona);
			System.out.println("Persona añadida: " + persona);
		}

		System.out.println("\nLista de personas:");
		for (Persona p : listaPersonas) {
			System.out.println(p);
		}
	}

}
