package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Utils.DBUtils;

public class ClienteModelo {

	public ArrayList<ClienteDTO> recuperarNOmbreTelefono() throws ClassNotFoundException, SQLException {

		Connection conexionBD = DBUtils.conexionBBDD();

		Statement statement = conexionBD.createStatement();
		ResultSet clientes = statement.executeQuery("SELECT * FROM customers");

		ArrayList<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();

		while (clientes.next() != false) {

			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);

		}
		conexionBD.close();
		return listaClientes;

	}
}
