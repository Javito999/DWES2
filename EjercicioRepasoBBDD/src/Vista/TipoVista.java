package Vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Controlador.TipoControlador;
import DTO.TipoDTO;

public class TipoVista {

	public void menuListarLibrosPorFiltros() throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Dígame el id del libro");
		int idPublicacion = sc.nextInt();
		sc.nextLine();
		System.out.println("Dígame el titulo del libro");
		String titulo = sc.nextLine();
		System.out.println("Dígame el autor del libro");
		String autor = sc.nextLine();
		System.out.println("Dígame el numero de la edición");
		int numEdicion = sc.nextInt();
		sc.nextLine();
		System.out.println("Dígame el precio del libro");
		Double precio = sc.nextDouble();
		sc.nextLine();
		
		TipoControlador tipoControlador = new TipoControlador();
		ArrayList<TipoDTO> listaLibros = tipoControlador.listarRegistroLibros(idPublicacion, titulo, autor, numEdicion, precio);
		
		
		for(TipoDTO libro : listaLibros) {
			
			System.out.println(libro.getIdTipo());
		}
		
	}
	
	
	
}
