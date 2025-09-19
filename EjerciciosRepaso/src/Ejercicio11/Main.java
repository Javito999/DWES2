package Ejercicio11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Persona>  listaPersonas = new ArrayList<>();
		
		while(true) {
			System.out.println("Introduce nombre");
			String nombre = sc.nextLine();
			
			if(nombre.equals("salir")) {
				break;
				
			}
			
			System.out.println("edad");
			int edad = sc.nextInt();
			sc.nextLine();
			
			Persona persona = new Persona(nombre, edad);
			
			listaPersonas.add(persona);
			
			System.out.println("nombre" + persona.getNombre() + "edad " + persona.getEdad());
			
			
			
			
		}
		
		
		

	}

}
