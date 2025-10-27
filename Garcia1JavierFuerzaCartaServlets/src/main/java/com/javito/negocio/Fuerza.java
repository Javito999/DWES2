package com.javito.negocio;

import java.io.IOException;

import com.javito.modelo.ConsultaDatos;

public class Fuerza {

	public double calculaFuerza(String nombre) throws NumberFormatException, IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();

		return consultaDatos.consultaFuerza(nombre);
	}

}
