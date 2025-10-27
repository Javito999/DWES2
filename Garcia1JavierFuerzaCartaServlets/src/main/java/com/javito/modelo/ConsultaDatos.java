package com.javito.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

	@SuppressWarnings("resource")
	public double consultaFuerza(String nombre) throws NumberFormatException, IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("fuerza.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		
		double coste = 0;
		double vida = 0;
		double dano = 0;
		double indice = (dano * vida) / coste;

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("-");
			if (partes.length == 4) {
				String nombreUsuario = partes[0].trim();
				 coste = Double.parseDouble(partes[1].trim());
				 dano = Double.parseDouble(partes[2].trim());
				 vida = Double.parseDouble(partes[3].trim());

				if (nombreUsuario.equalsIgnoreCase(nombre)) {
					
					br.close();
					return (int) indice;
				}
			}
			
		}
		return indice;
		

	}

}
