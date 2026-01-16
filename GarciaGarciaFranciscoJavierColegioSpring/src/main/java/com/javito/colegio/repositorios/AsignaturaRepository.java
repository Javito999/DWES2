package com.javito.colegio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.javito.colegio.dtos.AsignaturaDTO;
import com.javito.colegio.entities.AsignaturasEntity;

public interface AsignaturaRepository extends CrudRepository<AsignaturasEntity, Integer> {

	@Query("select new com.javito.colegio.dtos.AsignaturaDTO(a.id,a.nombre,a.curso,a.tasa,a.activo) "
			+ "FROM com.javito.colegio.entities.AsignaturasEntity a "
			+ "WHERE (:id IS NULL OR  CAST (a.id AS STRING) LIKE CONCAT ('%',:id,'%')) " 
			+ "AND a.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ "AND a.curso LIKE CONCAT ('%',:curso,'%') " 
			+ "AND (:tasa IS NULL OR a.tasa = :tasa) "
			+ "AND a.activo = :activo ")
			
	ArrayList<AsignaturaDTO> buscaAsignaturaporID(
			@Param("id") Integer id, 
			@Param("nombre") String nombre,
			@Param("curso") String apellidos, 
			@Param("tasa") Integer tasa, 
			@Param("activo") Integer activo);

}
