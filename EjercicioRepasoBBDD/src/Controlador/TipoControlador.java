package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PublicacionDTO;
import DTO.TipoDTO;
import Modelo.TipoModelo;

public class TipoControlador {

	public Integer crearNuevoRegistro(int idPublicacion, String titulo, String autor, int nroEdicion, double precio,
			int stock, String idTipo) throws ClassNotFoundException, SQLException {
		;

		TipoModelo tm = new TipoModelo();

		return tm.crearNuevoRegistro(idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);

	}

	public ArrayList<PublicacionDTO> listarLibrosPorFiltros(int idPublicacion, String titulo, String autor,
			int nroEdicion, double precio, int stock, String idTipo) throws ClassNotFoundException, SQLException {

		TipoModelo tm = new TipoModelo();
		
		return tm.listarLibrosPorFiltros(idPublicacion, titulo, autor, nroEdicion, nroEdicion, stock, idTipo);

	}

}
