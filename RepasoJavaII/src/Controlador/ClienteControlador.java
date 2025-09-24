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

	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {
		ClienteModelo cm = new ClienteModelo();
		return cm.insertarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1,
				direccion2, ciudad, estado, codigoPostal, pais, representante, credito);
	}

	public Integer actualizarCliente(int numerocliente, String nombrecliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {

		ClienteModelo cm = new ClienteModelo();

		return cm.actualizarCliente(numerocliente, nombrecliente, apellidoContacto, nombreContacto, telefono,
				direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante, credito);

	}

	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {

		ClienteModelo cm = new ClienteModelo();

		return cm.borrarCliente(customerNumber);

	}

}
