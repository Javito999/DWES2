package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Model.ClienteModelo;

public class ClienteControlador {

	public ArrayList<ClienteDTO> telefonoFiltradoPorNombre(String nombre) throws ClassNotFoundException, SQLException {

		ClienteModelo cm = new ClienteModelo();
		return cm.telefonoFiltradoPorNombre(nombre);

	}

}
