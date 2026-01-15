package com.javito.colegio.servicio.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javito.colegio.dao.interfaces.IAsignaturasDAO;
import com.javito.colegio.dtos.AsignaturaDTO;
import com.javito.colegio.servicio.interfaces.IAsignaturasService;

@Service
public class AsignaturasServiceImpl implements IAsignaturasService {
	
	@Autowired 
	IAsignaturasDAO asignaturasDAO;

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertarAsignatura(int id, String nombre, String curso, Integer tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAsignatura(int id, String nombre, String curso,Integer tasa, int activo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrarAsignatura(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<AsignaturaDTO> obtenerAsignaturas(Integer id, String nombre, String curso, Integer tasa, String activo)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	

}
