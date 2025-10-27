package com.javito.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javito.modelo.ConsultaDatos;
import com.javito.modelo.IConsultaDatos;

@Component
public class Cartas implements ICartas {

	private final ConsultaDatos consultaDatos_1;

	@Autowired
	IConsultaDatos consultaDatos;

	Cartas(ConsultaDatos consultaDatos_1) {
		this.consultaDatos_1 = consultaDatos_1;
	}

	@Override
	public double muestraCartas(String nombre) throws IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();

		return consultaDatos.consultaCartas(nombre);

	}

}
