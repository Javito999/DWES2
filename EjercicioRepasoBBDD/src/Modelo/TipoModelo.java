package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PublicacionDTO;
import DTO.TipoDTO;
import Utils.DBUtils;

public class TipoModelo {

	public Integer crearNuevoRegistro(int idPublicacion, String titulo, String autor, int nroEdicion,
			double precio, int stock, int idTipo) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO publicacion (idPublicacion," + "titulo, autor, nroEdicion, precio, idTipo)"
				+ "VALUES (?,?,?,?,?,?,?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(query);

		
		ps.setInt(1, idPublicacion);
		ps.setString(2, titulo);
		ps.setString(3, autor);
		ps.setInt(4, nroEdicion);
		ps.setDouble(5, precio);
		ps.setInt(6, stock);
		ps.setInt(7, idTipo);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;

	}

	public ArrayList<TipoDTO> listarRegistroLibros(Integer idPublicacion, String titulo, String autor, int numEdicion,
			double precio) throws ClassNotFoundException, SQLException {

		Connection connectionBD = DBUtils.conexionBBDD();

		String query = ("SELECT * FROM tipo t inner join publicacion p on t.idtipo = p.idtipo");

		PreparedStatement ps = connectionBD.prepareStatement(query);
		ps.setString(1, "%" + idPublicacion + "%");
		ps.setString(2, "%" + titulo + "%");
		ps.setString(3, "%" + autor + "%");
		ps.setString(4, "%" + numEdicion + "%");
		ps.setDouble(5, precio);

		ResultSet libros = ps.executeQuery();

		ArrayList<TipoDTO> listaLibros = new ArrayList<>();

		while (libros.next()) {

			TipoDTO t = new TipoDTO(libros.getInt("idPublicacion"));

			listaLibros.add(t);

		}
		connectionBD.close();

		return listaLibros;

	}

}
