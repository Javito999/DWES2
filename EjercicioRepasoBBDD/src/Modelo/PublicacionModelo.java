package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.PublicacionDTO;
import Utils.DBUtils;

public class PublicacionModelo {
	
	public ArrayList<PublicacionDTO> recuperarNombreLibro() throws ClassNotFoundException, SQLException {

		Connection conexionBD = DBUtils.conexionBBDD();

		Statement statement = conexionBD.createStatement();
		ResultSet libros = statement.executeQuery("SELECT * FROM publicacion");

		ArrayList<PublicacionDTO> listaLibros = new ArrayList<PublicacionDTO>();

		while (libros.next() != false) {

			PublicacionDTO c = new PublicacionDTO(libros.getInt("idTipo"), libros.getInt("idPublicacion"),
					libros.getString("titulo"), libros.getString("autor"),
							+  libros.getInt("numeroEdicion"), libros.getInt("precio"),
							false);
			listaLibros.add(c);

		}
		conexionBD.close();
		return listaLibros;

	}

}
