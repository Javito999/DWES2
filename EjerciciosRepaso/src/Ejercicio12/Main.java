package Ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Persona> personas = new ArrayList<>();
        
        System.out.println("Introductor de personas opcionales (escribe 'salir' para terminar)");
        
        while (true) {
            System.out.print("Introduce nombre (vacío para no inicializar): ");
            String nombre = br.readLine();
            
            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }
            
            System.out.print("Introduce edad (vacío para no inicializar): ");
            String edadStr = br.readLine();
            
            Persona persona = new Persona(nombre, edadStr);
            personas.add(persona);
            System.out.println("Persona añadida: " + persona);
        }
        
        System.out.println("\nLista de personas:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }


}
