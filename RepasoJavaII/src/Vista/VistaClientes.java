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

		// imprimir resultado

		for (ClienteDTO cliente : listaClientes) {

			System.out.println(cliente.getNombre() + " " + cliente.getTelefono());
		}

	}

	public void menuInsertaCliente() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el numero del cliente");
		int numeroCliente = sc.nextInt();
		sc.nextLine();
		System.out.println("Intorduzcael nombre");
		String nombreCliente = sc.nextLine();
	
		ifSystem.out.println("Introduzca el apellido");
		String apellidocliente = sc.nextLine();
		System.out.println("introduzca el nombre del contacto");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca el telegono del cliente");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la dirección del cliente: ");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la dirección 2 del cliente: ");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el código postal del cliente:");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		System.out.println("Introduzca el credito (numero con decimales");
		Double credito = sc.nextDouble();
		
		ClienteControlador controladorClientes = new ClienteControlador();
		// llamada al controlador con los datos recogidos
		int resutado = controladorClientes.insertarCliente(numeroCliente, nombreCliente, apellidocliente, nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante, credito);
		
		if(resutado == 1) {
			System.out.println("Se ha introducido correctamente");
		}else {
			System.out.println("Se ha producido un error al introducir el cliente");
		}
		
		
		
	}
	
	
	
	
	

}
