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
	public Integer consultaEdad(String nombre) throws IOException {
		// TODO Auto-generated method stub
		File f = ResourceUtils.getFile("classpath:Personas.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		while((linea = br.readLine()) != null) {
			if(linea.contains(nombre)) {
				String[] arrayPersona = linea.split("-");
				return Integer.parseInt(arrayPersona[1]);
			}
		}
		
		br.close();
		
		return null;
	}

	
	
}
