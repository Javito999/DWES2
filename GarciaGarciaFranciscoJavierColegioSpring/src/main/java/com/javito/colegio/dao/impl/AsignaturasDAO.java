package com.javito.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javito.colegio.dao.interfaces.IAlumnoDAO;
import com.javito.colegio.dao.interfaces.IAsignaturasDAO;
import com.javito.colegio.dtos.AlumnoDTO;
import com.javito.colegio.dtos.AsignaturaDTO;
import com.javito.colegio.repositorios.AsignaturaRepository;

@Repository

public class AsignaturasDAO implements IAsignaturasDAO {
	@Autowired
	AsignaturaRepository asignaturaRepository;
	

	@Override
	public ArrayList<AsignaturaDTO> obtenerTodasAsignaturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturasPorId(Integer id, String nombre, String curso, Integer tasa,
			int activo) {
		// TODO Auto-generated method stub
		return asignaturaRepository.buscaAsignaturaporID(id, nombre, curso, tasa, activo);
	}

	@Override
	public int insertarAsignatura(Integer id, String nombre, String curso, Integer tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAsignatura(Integer id, String nombre, String curso, Integer tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarAsignatura(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
