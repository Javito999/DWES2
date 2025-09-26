package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.TipoControlador;
import DTO.TipoDTO;

public class TipoVista {

	public void menuCreaNuevoRegistro() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, introduzca el idPublicacion");
		Integer idPublicacion = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor, introduzca el titulo");
		String titulo = sc.nextLine();
		System.out.println("Por favor, introduzca el autor");
		String autor = sc.nextLine();
		System.out.println("Por favor, introduzca el número de la edición");
		Integer nroEdicion = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor, introduzca el precio");
		Integer precio = sc.nextInt();
		System.out.println("Por favor, introduzca el stock");
		int stock = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor, introduzca el idTipo");
		String idTipo = sc.nextLine();
		
		

		TipoControlador tc = new TipoControlador();

		int resultado = tc.crearNuevoRegistro(idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);

		if (resultado == 1) {
			System.out.println("Se ha introducido correctamente");
		} else {
			System.out.println("Se ha producido un error al introducir el cliente");
		}

	}

	

}
