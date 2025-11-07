package com.javito.negocio;

import java.io.IOException;

import com.javito.ForEachComboSpringBoot.beans.Jugador;

public interface ILobos {

	Jugador  asignarRol(int idJugador) throws IOException;

	String asignarRol();
	
	
}
