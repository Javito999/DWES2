package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.ClienteControlador;
import DTO.ClienteDTO;

public class VistaClientes {

	public void menuRecuperaNOmbreTelefono() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el nombre del empleado");
		String nombreEmpleado = sc.nextLine();

		ClienteControlador controladorClientes = new ClienteControlador();
		ArrayList<ClienteDTO> listaClientes = controladorClientes.telefonoFiltradoPorNombre(nombreEmpleado);

		//imprimir resultado
		
		for(ClienteDTO cliente :  listaClientes) {
			
			System.out.println(cliente.getNombre() + " "
					+ cliente.getTelefono());
		}
		
	}
	
	//imprimir resultado
	
}
