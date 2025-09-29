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

	public Integer crearNuevoRegistro(int idPublicacion, String titulo, String autor, int nroEdicion, double precio,
			int stock, String idTipo) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO publicacion (idPublicacion," + "titulo, autor, nroEdicion, precio, stock, idTipo)"
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
		ps.setString(7, idTipo);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;

	}

	public ArrayList<PublicacionDTO> listarLibrosPorFiltros(int idPublicacion, String titulo, String autor,
			int nroEdicion, int precio, int stock, String idTipo) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM publicacion WHERE idpublicacion LIKE ? OR titulo LIKE ? OR autor LIKE ?"
				+ "OR nroedicion LIKE ? OR precio LIKE ? OR stock LIKE ? OR idtipo LIKE ? ";

		Connection connection = DBUtils.conexionBBDD();

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, "%" + idPublicacion + "%");
		ps.setString(2, "%" + titulo + "%");
		ps.setString(3, "%" + autor + "%");
		ps.setString(4, "%" + nroEdicion + "%");
		ps.setString(5, "%" + precio + "%");
		ps.setString(6, "%" + stock + "%");
		ps.setString(7, "%" + idTipo + "%");

		ResultSet libros = ps.executeQuery();

		ArrayList<PublicacionDTO> listaLibros = new ArrayList<>();

		while (libros.next()) {

			PublicacionDTO p = new PublicacionDTO(libros.getString("idtipo"), libros.getInt("idpublicacion"),
					libros.getString("titulo"), libros.getString("autor"), libros.getInt("nroedicion"),
					libros.getInt("precio"), libros.getInt("stock"));

			listaLibros.add(p);
		}

		connection.close();

		return listaLibros;

	}

}
