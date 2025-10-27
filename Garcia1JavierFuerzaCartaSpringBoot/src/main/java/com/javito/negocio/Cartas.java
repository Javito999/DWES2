package com.javito.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javito.modelo.ConsultaDatos;
import com.javito.modelo.IConsultaDatos;

@Component
public class Cartas implements ICartas {

	@Autowired
	IConsultaDatos consultaDatos;

	@Override
	public double muestraFuerza(String nombre) throws IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();
		return consultaDatos.consultaFuerza(nombre);
	}

}
