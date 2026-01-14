package com.javito.colegio.dao.interfaces;

import java.util.ArrayList;

import com.javito.colegio.dtos.AsignaturaDTO;

public interface IAsignaturasDAO {

	ArrayList<AsignaturaDTO> obtenerTodasAsignaturas();

	ArrayList<AsignaturaDTO> obtenerAsignaturasPorId(Integer id, String nombre, String curso, int tasa, int activo);

	int insertarAsignatura(Integer id, String nombre, String curso, int tasa, int activo);

	int actualizarAsignatura(Integer id, String nombre, String curso, int tasa, int activo);

	int borrarAsignatura(int id);

}
