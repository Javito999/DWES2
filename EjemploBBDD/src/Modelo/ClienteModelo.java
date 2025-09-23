package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public ArrayList<ClienteDTO> recuperarNOmbreTelefonoFiltrado(String nombre)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customers where customerName LIKE ?";
		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + nombre + "%");

		ResultSet clientes = ps.executeQuery();

		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();

		while (clientes.next() != false) {

			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);

		}

		conexionBD.close();

		return listaClientes;

	}

	public ArrayList<ClienteDTO> recuperarOmbreTlfnFiltrarNombreTfnPais(String nombre, String tlfno, String pais)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customersWhere customerName LIKE ? OR " + "phone LIKE ? OR country LIKE ?";
		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + nombre + "%");

		ResultSet clientes = ps.executeQuery();

		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();

		while (clientes.next() != false) {

			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);

		}

		conexionBD.close();

		return listaClientes;

	}

	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO customers (customerNumber, customerName,contactLastName, contactFirstName, phone, addressLine1,"
				+ " addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(sql);
		ps.setInt(1, numerocliente);
		ps.setString(2, nombreCliente);
		ps.setString(3, apellidoContacto);
		ps.setString(4, nombreContacto);

		int resultado = ps.executeUpdate();
		conexionBD.close();
		return resultado;

	}

	public Integer actualizaCliente(int numerocliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) {

		// no terminado, sigue el mismo modelo que el de insertarCliente

		return representante;

	}

	public Integer borrarCliente(int numeroCliente) throws ClassNotFoundException, SQLException {

		String query = "DELETE FROM customer where customername = ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setInt(1, numeroCliente);

		int resultado = ps.executeUpdate();
		conexionBD.close();
		return resultado;

	}

}
