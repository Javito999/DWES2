package com.javito.foreach.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

	public String consultaJugadores(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String linea;

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("-");
			if (partes.length == 4) {
				String idJugador = partes[0].trim();
				String nombreJugador = partes[1].trim();

				if (nombreJugador.equalsIgnoreCase(nombre)) {

					return nombreJugador;
				}

			}

		}
		br.close();
		return null;
	}

	public String consultaRoles(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("roles.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String linea;

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("-");
			if (partes.length == 4) {
				String rolJugador = partes[0].trim();

				if (rolJugador.equalsIgnoreCase(nombre)) {

					return rolJugador;
				}

			}

		}
		br.close();
		return null;
	}

}
