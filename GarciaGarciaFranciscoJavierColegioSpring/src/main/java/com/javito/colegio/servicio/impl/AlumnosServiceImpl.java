package com.javito.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javito.colegio.dao.interfaces.IAlumnoDAO;
import com.javito.colegio.dtos.AlumnoDTO;
import com.javito.colegio.servicio.interfaces.IAlumnosService;

@Service
public class AlumnosServiceImpl implements IAlumnosService {
	@Autowired
	IAlumnoDAO alumnosDAO;
	
	@Override
	public int insertarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		return alumnosDAO.insertarAlumno(id, nombre, apellido, idMunicipio, familiaNumerosa, activo);
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(Integer id, String nombre, String apellido,
			int familiaNumerosa, int activo) {
		return alumnosDAO.obtenerAlumnosPorIdNombreApellido(id, nombre, apellido, familiaNumerosa, activo);
	}



	@Override
	public int actualizarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		return alumnosDAO.actualizarAlumno(id, nombre, apellido, idMunicipio, familiaNumerosa, activo);
	}

	@Override
	public int borrarAlumno(int id) {
		return alumnosDAO.borrarAlumno(id);
	}

}