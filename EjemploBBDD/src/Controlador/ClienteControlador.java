package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Modelo.ClienteModelo;

public class ClienteControlador {

	public ArrayList<ClienteDTO> recuperarNombreTelefono(String nombre) throws ClassNotFoundException, SQLException {

		ClienteModelo cm = new ClienteModelo();

		return cm.recuperarNOmbreTelefonoFiltrado(nombre);

	}
	
	

	
	/*public Integer insertarCliente(int numerocliente, String nombreCliente, String
			apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad,
			String estado,
			String codigoPostal, String pais, int representante, Double credito) {
				
	ClienteModelo CM = new ClienteModelo();
	
		
		
		//return cm.insertarCliente(numeroCliente, nombreCliente, apellid,.apellidoContacto.);
		
		
		*/
	}

