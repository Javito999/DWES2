package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.tomcat.jakartaee.bcel.classfile.Field;

public class ConsultaDatos {

	public Integer consultaEdad(String nombre) throws IOException {

		String path = Thread.currentThread().getContextClassLoader().getResource("Personas.txt").getPath();
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		String linea;

		while ((linea = br.readLine()) != null) {

			if (linea.contains(nombre)) {
				String[] arrayPersona = linea.split("-");
				int edad = Integer.parseInt(arrayPersona[1]);
				br.close();
				return edad;
			}
		}

		br.close();

		return null;

	}
}
