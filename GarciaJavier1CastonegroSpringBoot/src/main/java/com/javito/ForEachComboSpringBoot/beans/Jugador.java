package com.javito.ForEachComboSpringBoot.beans;

import java.io.Serializable;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idJugador;
	private String nombreJugador;
	private String rolJugador;

	public Jugador() {
	}

	public Jugador(int idJugador, String nombreJugador) {
		this.idJugador = idJugador;
		this.nombreJugador = nombreJugador;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getRolJugador() {
		return rolJugador;
	}

	public void setRolJugador(String rolJugador) {
		this.rolJugador = rolJugador;
	}
}