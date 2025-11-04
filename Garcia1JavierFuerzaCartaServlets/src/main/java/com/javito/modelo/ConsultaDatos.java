package com.javito.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

	public double consultaFuerza(String nombre) throws NumberFormatException, IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("magic.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String linea;

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("-");
			if (partes.length == 4) {
				String nombreUsuario = partes[0].trim();
				double coste = Double.parseDouble(partes[1].trim());
				double dano = Double.parseDouble(partes[2].trim());
				double vida = Double.parseDouble(partes[3].trim());
				double indice = (dano * vida) / coste;

				if (nombreUsuario.equalsIgnoreCase(nombre)) {

					return indice;
				}
			}

		}
		br.close();
		return 0;

	}

}
