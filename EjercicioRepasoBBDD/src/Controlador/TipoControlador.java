package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.TipoDTO;
import Modelo.TipoModelo;

public class TipoControlador {

	public ArrayList<TipoDTO> listarRegistroLibros(Integer idPublicacion, String titulo, String autor,
			int numEdicion, double precio) throws ClassNotFoundException, SQLException {

		TipoModelo tm = new TipoModelo();

		return tm.listarRegistroLibros(idPublicacion, titulo, autor, numEdicion, precio);

	}

}
