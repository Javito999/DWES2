package com.javito.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class ConsultaDatos implements IConsultaDatos {

	@Override
	public Double consultaCartas(String nombre) throws IOException {

		File f = ResourceUtils.getFile("classpath:cartas.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		double contador = 0;

		String linea;
		while ((linea = br.readLine()) != null) {

			String[] partes = linea.split("-");

			if (partes.length == 2) {
				String jugador = partes[0].trim();

				if (jugador.equalsIgnoreCase(nombre)) {
					contador++;
				}
			}

		}
		br.close();
		return contador;

	}
}
