package com.javito.colegio.dao.interfaces;

import java.util.ArrayList;

import com.javito.colegio.dtos.DesplegableDTO;

public interface IDesplegableDAO {
	ArrayList<DesplegableDTO> desplegableMunicipios();

	ArrayList<DesplegableDTO> desplegableAlumnos();

	ArrayList<DesplegableDTO> desplegableAsignaturas();

}
