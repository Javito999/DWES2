package servicios;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.AlumnoDTO;
import dao.IAlumnosDAO;
import daoImplement.AlumnosDAOImp;

public class AlumnosServiceImp implements IAlumnosService {
	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnos() throws SQLException {
	IAlumnosDAO alumnos = new AlumnosDAOImp();
	return alumnos.obtenerTodosAlumnos();
	}

}
