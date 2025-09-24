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

	public Integer actualizarCliente(int numerocliente, String nombrecliente, String apellidoContacto,
			String nombreContacto, String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito)
			throws ClassNotFoundException, SQLException {

		String query = "UPDATE customers SET customerName = CASE WHEN ? = '' THEN customerName ELSE ? END, "
				+ "contactLastName = CASE WHEN ? = '' THEN contactLastName ELSE ? END, "
				+ "contactFirstName = CASE WHEN ? = '' THEN contactFirstName ELSE ? END, "
				+ "phone = CASE WHEN ? = '' THEN phone ELSE ? END, "
				+ "addressLine1 = CASE WHEN ? = '' THEN addressLine1 ELSE ? END,"
				+ "addressLine2 = CASE WHEN ? = '' THEN addressLine2 ELSE ? END, "
				+ "city = CASE WHEN ? = '' THEN city ELSE ? END, " + "state = CASE WHEN ? = '' THEN state ELSE ? END, "
				+ "postalCode = CASE WHEN ? = '' THEN postalCode ELSE ? END, "
				+ "country = CASE WHEN ? = '' THEN country ELSE ? END, "
				+ "salesRepEmployeeNumber = CASE WHEN ? = '' THEN salesRepEmployeeNumber ELSE ? END, "
				+ "creditLimit = CASE WHEN ? = '' THEN creditLimit ELSE ? END " + "WHERE customerNumber = ?";

		Integer resultado = null;

		try (Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query)) {

			ps.setString(1, nombrecliente);
			ps.setString(2, nombrecliente);
			ps.setString(3, apellidoContacto);
			ps.setString(4, apellidoContacto);
			ps.setString(5, nombreContacto);
			ps.setString(6, nombreContacto);
			ps.setString(7, telefono);
			ps.setString(8, telefono);
			ps.setString(9, direccion1);
			ps.setString(10, direccion1);
			ps.setString(11, direccion2);
			ps.setString(12, direccion2);
			ps.setString(13, ciudad);
			ps.setString(14, ciudad);
			ps.setString(15, estado);
			ps.setString(16, estado);
			ps.setString(17, codigoPostal);
			ps.setString(18, codigoPostal);
			ps.setString(19, pais);
			ps.setString(20, pais);
			ps.setInt(21, representante);
			ps.setInt(22, representante);
			ps.setDouble(23, credito);
			ps.setDouble(24, credito);
			ps.setInt(25, numerocliente);
			resultado = ps.executeUpdate();
		}

		return resultado;

	}

	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {

		String query = "DELETE FROM customers where customerNumber = ?";

		Connection connection = DBUtils.conexionBBDD();

		PreparedStatement ps = null;

		Integer resultado = null;

		ps = connection.prepareStatement(query);
		ps.setInt(1, customerNumber);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;

	}

}
