package negocio;

import java.io.IOException;

import modelo.ConsultaDatos;

public class descuento {

	public int calculaDescuento(String nombre) throws IOException {

		ConsultaDatos consultaDatos = new ConsultaDatos();

		if (consultaDatos.consultaEdad(nombre) < 20) {
			return 5;

		} else {
			return 10;
		}

	}
}
