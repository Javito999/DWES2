package com.javito.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javito.modelo.IConsultaDatos;

@Component
public class Descuento implements IDescuento {

	@Autowired
	IConsultaDatos consultaDatos;

	@Override
	public int calculaDescuento(String nombre) throws IOException {
		if (consultaDatos.consultaEdad(nombre) < 20)

			return 5;

		else
			return 10;
	}

}
