package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		System.out.println("Introduzca el apellido");
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
		int representante = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el credito (numero con decimales");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido crédito");
		}

		ClienteControlador controladorClientes = new ClienteControlador();
		// llamada al controlador con los datos recogidos
		int resutado = controladorClientes.insertarCliente(numeroCliente, nombreCliente, apellidocliente,
				nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante,
				credito);

		if (resutado == 1) {
			System.out.println("Se ha introducido correctamente");
		} else {
			System.out.println("Se ha producido un error al introducir el cliente");
		}

	}

	public void menuActualizarCliente() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca por favor el número del cliente a actualizar: ");
		int numeroCliente = Integer.parseInt(leer.readLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombrecliente = leer.readLine();
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = leer.readLine();
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = leer.readLine();
		System.out.println("Introduzca por favor el telefono del cliente: ");
		String telefono = leer.readLine();
		System.out.println("Introduzca por favor la dirección del cliente: ");
		String direccion1 = leer.readLine();
		System.out.println("Introduzca por favor la dirección 2 del cliente: ");
		String direccion2 = leer.readLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = leer.readLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = leer.readLine();
		System.out.println("Introduzca por favor el código postal del cliente: ");
		String codigoPostal = leer.readLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = leer.readLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		try {
			representante = Integer.parseInt(leer.readLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido número de representante de ventas");
		}
		System.out.println("Introduzca por favor crédito (número con decimales): ");
		Double credito = 0.0;
		try {
			credito = Double.parseDouble(leer.readLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido crédito");
		}
		ClienteControlador controladorClientes = new ClienteControlador();
		int resultado = controladorClientes.actualizarCliente(numeroCliente, nombrecliente, apellidoContacto,
				nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante,
				credito);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el cliente con el número: " + numeroCliente + " con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el cliente con el número: " + numeroCliente);
		}
	}
	
	public void menuBorrarCliente() throws ClassNotFoundException,
	SQLException, IOException {
	
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Introduzca el número del cliente a borrar:");
	
		int numCliente = 0;
	
	try {
		numCliente = Integer.parseInt(leer.readLine());
	} catch (NumberFormatException e) {
		System.out.println("No se ha introducido el número del cliente");
	}
	
	ClienteControlador controladorClientes = new ClienteControlador();
	
	String resultado =
	(controladorClientes.borrarCliente(numCliente).equals(1))?"Cliente borrado con éxito\n":"No se ha encontrado ningún cliente con ese número\n";
	System.out.println(resultado);
	}

}
