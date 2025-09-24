package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import DTO.ClienteDTO;
import Utils.DBUtils;

public class ClienteModelo {

	public ArrayList<ClienteDTO> recuperarNombreTelefonoTodosClientes() throws ClassNotFoundException, SQLException {

		Connection conexionBD = DBUtils.conexionBBDD();

		Statement statement = conexionBD.createStatement();
		ResultSet clientes = statement.executeQuery("SELECT * FROM customers");

		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();

		while (clientes.next()) {

			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);

		}
		conexionBD.close();
		return listaClientes;

	}

	public ArrayList<ClienteDTO> telefonoFiltradoPorNombre(String nombre) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customers where customerName LIKE ? ";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombre + "%");

		ResultSet clientes = ps.executeQuery(); // ejecuitamos la query

		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();// almacenamos los resultados

		while (clientes.next()) {
			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));
			listaClientes.add(c);
		}
		conexionBD.close();
		return listaClientes;

	}

	public ArrayList<ClienteDTO> recuperarNOmbreTelefonoFiltrarPorNombrePais(String nombre, String telefono,
			String pais) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM customers WHERE customername LIKE ? OR phone LIKE ? OR country LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);
		ps.setString(1, "%" + nombre + "%");
		ps.setString(2, "%" + telefono + "%");
		ps.setString(3, "%" + pais + "%");

		ResultSet clientes = ps.executeQuery();

		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();

		while (clientes.next()) {

			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"), clientes.getString("phone"));

			listaClientes.add(c);
		}

		conexionBD.close();
		return listaClientes;

	}

	public Integer insertarCliente(int numeroCliente, String nombreCliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,"
				+ " addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(query);

		ps.setInt(1, numeroCliente);
		ps.setString(2, nombreCliente);
		ps.setString(3, apellidoContacto);
		ps.setString(4, nombreContacto);
		ps.setString(5, telefono);
		ps.setString(6, direccion1);
		ps.setString(7, direccion2);
		ps.setString(8, ciudad);
		ps.setString(9, estado);
		ps.setString(10, codigoPostal);
		ps.setString(11, pais);
		ps.setInt(12, representante);
		ps.setDouble(13, credito);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;

	}
}
