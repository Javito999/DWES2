package serviciesImp;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.AlumnoDTO;
import dao.IAlumnosDAO;
import daoImplement.AlumnosDAOImp;
import servicios.IAlumnosService;

public class AlumnosServiceImp implements IAlumnosService {
	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnos() throws SQLException {
		IAlumnosDAO alumnos = new AlumnosDAOImp();
		return alumnos.obtenerTodosAlumnos();
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(String id, String nombre, String apellido) {

		IAlumnosDAO alumnos = new AlumnosDAOImp();

		return alumnos.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido);
	}

	@Override
	public int insertarAlumno(String id, String nombre, String apellido, String idMunicipio, int familiaNumerosa,
			int activo) {
		IAlumnosDAO alumnos = new AlumnosDAOImp();
		return alumnos.insertarAlumno(id, nombre, apellido, idMunicipio,
		familiaNumerosa, activo);
	}

}
