package com.javito.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

	public Integer consultaCartas(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("cartas.txt").getPath();

		File f = new File(path);

		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		int contador = 0;

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
		return contador;

	}
}
