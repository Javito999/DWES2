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

		String linea;

		while ((linea = br.readLine()) != null) {

			if (linea.contains(nombre)) {

				String[] arrayJugador = linea.split("-");
					
				int carta = Integer.parseInt(arrayJugador[1]);
				
				br.close();
				return carta;
				
			}

		}

		br.close();

		return null;

	}

}
