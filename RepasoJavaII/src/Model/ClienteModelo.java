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
		
		ResultSet clientes = ps.executeQuery(); //ejecuitamos la query
		
		ArrayList<ClienteDTO> listaClientes = new ArrayList<>();//almacenamos los resultados
		
		while(clientes.next()) {
			ClienteDTO c = new ClienteDTO(clientes.getString("customerName"),
					clientes.getString("phone"));
			listaClientes.add(c);
		}
		conexionBD.close();
		return listaClientes;

	}

}
