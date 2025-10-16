package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dtos.TipoDTO;
import utils.DBUtils;

public class TipoModelo {
	public Integer insertarTipo(String idTipo, String descripcion) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO tipo (idtipo, descripcion) VALUES (?, ?)";

		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setString(1, idTipo);
			ps.setString(2, descripcion);

			return ps.executeUpdate();
		}
	}
	
	

	public ArrayList<TipoDTO> buscarTipos(String idTipo, String descripcion)
			throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM tipo ";

		if (idTipo != null && !idTipo.isEmpty()) {
			sql += "AND idtipo = ? ";
		}
		if (descripcion != null && !descripcion.isEmpty()) {
			sql += "AND descripcion LIKE ? ";
		}
		ArrayList<TipoDTO> listaTipos = new ArrayList<>();

		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {

			int parameterIndex = 1;
			if (idTipo != null && !idTipo.isBlank()) {
				ps.setString(parameterIndex++, idTipo);
			}
			if (descripcion != null && !descripcion.isBlank()) {
				ps.setString(parameterIndex, "%" + descripcion + "%");
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TipoDTO tipo = new TipoDTO(rs.getString("idtipo"), rs.getString("descripcion"));
				listaTipos.add(tipo);
			}

			return listaTipos;
		}
	}

	public Integer actualizarTipo(String idTipo, String descripcion) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE tipo SET descripcion = ? WHERE idtipo = ?";

		try (Connection conexion = DBUtils.conexionBBDD(); PreparedStatement ps = conexion.prepareStatement(sql)) {

			ps.setString(1, descripcion);
			ps.setString(2, idTipo);

			return ps.executeUpdate();
		}
	}

}
