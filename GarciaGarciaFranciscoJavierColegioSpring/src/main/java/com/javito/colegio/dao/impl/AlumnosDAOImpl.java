package com.javito.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javito.colegio.dao.interfaces.IAlumnoDAO;
import com.javito.colegio.dtos.AlumnoDTO;
import com.javito.colegio.entities.AlumnoEntity;
import com.javito.colegio.entities.MunicipioEntity;
import com.javito.colegio.repositorios.AlumnoRepository;
import com.javito.colegio.repositorios.MunicipioRepository;

@Repository
public class AlumnosDAOImpl implements IAlumnoDAO {
	@Autowired
	MunicipioRepository municipioRepository;

	@Autowired
	AlumnoRepository alumnosRepository;

	@Override
	public int insertarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		// Encontramos el municipio
		MunicipioEntity municipio = municipioRepository.findById(idMunicipio).get();

		// Creamos la entidad Alumno
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, apellido, familiaNumerosa, activo, municipio);

		alumnosRepository.save(alumno);
		return alumno.getId();
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerTodosAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AlumnoDTO> obtenerAlumnosPorIdNombreApellido(Integer id, String nombre, String apellido,
			int familiaNumerosa, int activo) {
		return alumnosRepository.buscaAlumnoporIDyNombre(id, nombre, apellido, familiaNumerosa, activo);
	}

	@Override
	public int actualizarAlumno(int id, String nombre, String apellido, int idMunicipio, int familiaNumerosa,
			int activo) {
		// Encontramos el municipio
		MunicipioEntity municipio = municipioRepository.findById(idMunicipio).get();

		// Creamos la entidad Alumno
		AlumnoEntity alumno = new AlumnoEntity(id, nombre, apellido, familiaNumerosa, activo, municipio);

		alumnosRepository.save(alumno);
		return alumno.getId();
	}

	@Override
	public int borrarAlumno(int id) {
		AlumnoEntity alumno = alumnosRepository.findById(id).get();
		alumno.setActivo(0);
		alumnosRepository.save(alumno);
		return alumno.getId();
	}

	@Override
	public boolean esFamiliaNumerosa(String idAlumno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int contarAsignaturasMatriculadas(String idAlumno) {
		// TODO Auto-generated method stub
		return 0;
	}

}