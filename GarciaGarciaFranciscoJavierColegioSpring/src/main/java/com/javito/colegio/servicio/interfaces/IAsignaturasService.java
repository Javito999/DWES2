package com.javito.colegio.servicio.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.javito.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasService {
	
	public ArrayList<AsignaturaDTO> obtenerAsignaturas(Integer id, String nombre, String curso, Integer tasa, int activo) throws SQLException;
	public int insertarAsignatura(int id, String nombre, String curso, Integer
	tasa,int activo);
	public int actualizarAsignatura(int id, String nombre, String curso, Integer
			tasa,int activo);
	public int borrarAsignatura(int id);
	ArrayList<AsignaturaDTO> obtenerAsignaturas() throws SQLException;

}
