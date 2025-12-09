package daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DesplegableDTO;
import dao.IDesplegableDAO;
import utils.DBUtils;

public class DesplegableDAOImp implements IDesplegableDAO {
	
	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
	String sql = "SELECT * FROM municipios ORDER BY nombre";
	ArrayList<DesplegableDTO> listaMunicipios = new ArrayList<>();
	try {
	Connection connection = DBUtils.conexion();
	PreparedStatement ps = connection.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	DesplegableDTO a = new DesplegableDTO(rs.getInt(1),
	rs.getString(5));
	listaMunicipios.add(a);
	}
	} catch (SQLException e) {
	
	e.printStackTrace();
	}
	return listaMunicipios;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}


}
