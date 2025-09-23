package Vista;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.ClienteControlador;
import DTO.ClienteDTO;

public class VistaClientes {
	
	public void menuRecuperaNombreTlfnFiltrarNOmbre() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca para filtrar");
		String nombreAFiltrar = sc.nextLine();
		
		ClienteControlador controladorClientes = new ClienteControlador();
		
		ArrayList<ClienteDTO> listaClientes = controladorClientes.recuperarNombreTelefono(nombreAFiltrar);
		
		for(ClienteDTO cliente : listaClientes) {
			
			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());
		}
		
	}

	public void menuInsertarCliente() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Introduce numero del cliente");
		sc.nextInt();
		sc.nextLine();
		
		
		
	}
	
	public void menuActulizarCliente() {
		Scanner sc = new Scanner(System.in);
		// no terminado
		
	}
	
	public void menuBorrarCliente() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce numero de cliente a borrar");
		
		int numCliente = sc.nextInt();
		sc.nextLine();
		
		
		
		
	}
}
