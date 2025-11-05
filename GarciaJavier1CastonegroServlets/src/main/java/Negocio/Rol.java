package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.javito.foreach.beans.DesplegableDTO;

public class Rol {
	
	public static List<DesplegableDTO> obtenerJugadores() throws NumberFormatException, IOException {
        List<DesplegableDTO> jugadores = new ArrayList<>();

       
            String path = Thread.currentThread().getContextClassLoader().getResource("jugadores.txt").getPath();
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;

            while ((linea = br.readLine()) != null) {
               
                String[] partes = linea.split("-");
                if (partes.length >= 2) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    jugadores.add(new DesplegableDTO(id, nombre));
                }
            }
            br.close();
      

        return jugadores;
    }

    public static String obtenerNombreJugadorPorId(int id) throws NumberFormatException, IOException {
        for (DesplegableDTO j : obtenerJugadores()) {
            if (j.getIdJugador() == id) {
                return j.getNombre();
            }
        }
        return null;
    }

    public static String asignarRolAleatorio() {
        List<String> roles = new ArrayList<>();

        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("roles.txt").getPath();
            File f = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;

            while ((linea = br.readLine()) != null) {
                roles.add(linea.trim());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (roles.isEmpty()) {
            return "sin rol";
        }

        Random random = new Random();
        return roles.get(random.nextInt(roles.size()));
    }

}
