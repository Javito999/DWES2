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

	public ArrayList<TipoDTO> listarRegistroLibros(Integer idPublicacion, String titulo, String autor,
			int numEdicion, double precio) throws ClassNotFoundException, SQLException {

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
