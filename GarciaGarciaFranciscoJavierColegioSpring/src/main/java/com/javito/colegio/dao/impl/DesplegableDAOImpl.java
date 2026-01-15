package com.javito.colegio.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javito.colegio.dao.interfaces.IDesplegableDAO;
import com.javito.colegio.dtos.DesplegableDTO;
import com.javito.colegio.entities.AsignaturasEntity;
import com.javito.colegio.entities.MunicipioEntity;
import com.javito.colegio.repositorios.AsignaturaRepository;
import com.javito.colegio.repositorios.MunicipioRepository;

@Repository
public class DesplegableDAOImpl implements IDesplegableDAO {

	@Autowired // Inyectamos el repository
	private MunicipioRepository municipioRepository;
	@Autowired AsignaturaRepository asignaturaRepository;

	@Override
	public ArrayList<DesplegableDTO> desplegableMunicipios() {
		// Utilizamos el método que nos "regala" Spring data JPA
		Iterable<MunicipioEntity> listaEntidadesMunicipios = municipioRepository.findAll();
		ArrayList<DesplegableDTO> listaMunicipios = mapeoEntidadMunicioComboDTO(listaEntidadesMunicipios);
		return listaMunicipios;
	}

	private ArrayList<DesplegableDTO> mapeoEntidadMunicioComboDTO(Iterable<MunicipioEntity> listaEntidadesMunicipios) {
		ArrayList<DesplegableDTO> listaCombos = new ArrayList<>();
		for (MunicipioEntity municipiosEntity : listaEntidadesMunicipios) {
			listaCombos.add(new DesplegableDTO(municipiosEntity.getIdMunicipio(), municipiosEntity.getNombre()));
		}
		return listaCombos;

	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DesplegableDTO> desplegableAsignaturas() {
		Iterable<AsignaturasEntity> listaAsignaturas = asignaturaRepository.findAll();
		
		
		return null;
	}

}