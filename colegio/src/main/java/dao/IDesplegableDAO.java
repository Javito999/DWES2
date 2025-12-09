package dao;

import java.util.ArrayList;

import DTO.DesplegableDTO;

public interface IDesplegableDAO {
	ArrayList<DesplegableDTO> desplegableMunicipios();

	ArrayList<DesplegableDTO> desplegableAlumnos();

	ArrayList<DesplegableDTO> desplegableAsignaturas();
}
