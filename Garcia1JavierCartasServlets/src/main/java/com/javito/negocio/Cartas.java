package com.javito.negocio;

import java.io.IOException;

import com.javito.modelo.ConsultaDatos;

public class Cartas {

	public int muestraCartas(String nombre) throws IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();

		return consultaDatos.consultaCartas(nombre);

	}

}
