package com.javito.foreach.beans;

import java.io.Serializable;

public class DesplegableDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idJugador;
	private String nombre;

	public DesplegableDTO() {
		super();
	}

	public DesplegableDTO(Integer idJugador, String nombre) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
	}

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
