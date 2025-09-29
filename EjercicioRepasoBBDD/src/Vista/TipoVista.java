package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.TipoControlador;
import DTO.PublicacionDTO;
import DTO.TipoDTO;

public class TipoVista {

	public void menuCreaNuevoRegistro() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, introduzca el idPublicacion");
		int idPublicacion = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor, introduzca el titulo");
		String titulo = sc.nextLine();
		System.out.println("Por favor, introduzca el autor");
		String autor = sc.nextLine();
		System.out.println("Por favor, introduzca el número de la edición");
		int nroEdicion = sc.nextInt();
		sc.nextLine();
		System.out.println("Por favor, introduzca el precio");
		int precio = sc.nextInt();
		sc.nextLine();
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

	public void menuBusquedaPorFiltros() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("***BUSQUEDA POR FILTROS***");
		System.out.println("Buscar por idpublicacion");
		System.out.println("Buscar por el titulo de la publicacion");
		System.out.println("Buscar por el autor");
		System.out.println("Buscar por el numero de la edicion");
		System.out.println("Buscar por el precio");
		System.out.println("Buscar por el stock");
		System.out.println("Buscar porel idTipo");

		int opcion = sc.nextInt();
		sc.nextLine();

		int idpublicacion = 0;
		String titulo = null;
		String autor = null;
		int nroedicion = 0;
		int precio = 0;
		int stock = 0;
		String idTipo = null;

		switch (opcion) {

		case 1:
			System.out.println("Introduzca idPublicacion: ");
			idpublicacion = sc.nextInt();
			sc.nextLine();
			break;

		case 2:
			System.out.println("Introduzca el titulo: ");
			titulo = sc.nextLine();
			break;

		case 3:
			System.out.println("Introduzca el autor: ");
			autor = sc.nextLine();
			break;

		case 4:
			System.out.println("Introduzca el numero de edicion");
			nroedicion = sc.nextInt();
			sc.nextLine();
			break;

		case 5:
			System.out.println("Introduzca el precio");
			precio = sc.nextInt();
			sc.nextLine();
			break;

		case 6:
			System.out.println("Introduzca el stock");
			stock = sc.nextInt();
			sc.nextLine();
			break;

		case 7:
			System.out.println("Introduzca el idTipo");
			idTipo = sc.nextLine();
			break;

		default:
			System.out.println("Opcion no valida");

			return;

		}
		
		TipoControlador t = new TipoControlador();
		
		ArrayList<PublicacionDTO> lista = t.listarLibrosPorFiltros(idpublicacion, titulo, autor, nroedicion, precio, stock, idTipo);

		//imprimo resultados
		
		for(PublicacionDTO p : lista) {
			
			System.out.println(p.getIdPublicacion() + " " + p.getAutor()
			+ " " + p.getIdTipo() + " " + p.getNumeroEdicion() + " " +
			p.getIdTipo() + " " + p.getTitulo());
			
			
		}
		
	}

}
