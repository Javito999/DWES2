package com.javito.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaturas")

public class AsignaturasEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "curso")
	private String curso;

	@Column(name = "tasa")
	private Integer tasa;

	@Column(name = "activo")
	private int activo;

	public AsignaturasEntity(int id, String nombre, String curso, Integer tasa, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
	}
	
	public AsignaturasEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getTasa() {
		return tasa;
	}

	public void setTasa(Integer tasa) {
		this.tasa = tasa;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
