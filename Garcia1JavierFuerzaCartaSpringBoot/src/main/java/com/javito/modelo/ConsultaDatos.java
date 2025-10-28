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
	public Double consultaFuerza(String nombre) throws NumberFormatException, IOException {

		File f = ResourceUtils.getFile("classpath:cartas.txt");
		
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
					
					return Math.floor(indice);
				}
			}
			
		}br.close();
		return (double) 0;
		

	}

}
