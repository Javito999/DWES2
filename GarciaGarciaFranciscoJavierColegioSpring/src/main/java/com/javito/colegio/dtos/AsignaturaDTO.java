package com.javito.colegio.dtos;

public class AsignaturaDTO {

	private int id;
	private String nombre;
	private String curso;
	private Integer tasa;
	private int activo;

	public AsignaturaDTO(int id, String nombre, String curso, Integer tasa, int activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.tasa = tasa;
		this.activo = activo;
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
