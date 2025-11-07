package com.javito.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.javito.ForEachComboSpringBoot.beans.DesplegableDTO;

@Component
public class ConsultaDatos implements IConsultaDatos {

    @Override
    public String obtenerNombrePorId(int idJugador) throws IOException {

        File f = ResourceUtils.getFile("classpath:listaJugadores.txt");

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("-");
            if (partes.length == 2) {
                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();

                if (id == idJugador) {
                    br.close();
                    return nombre;
                }
            }
        }

        br.close();
        return null;
    }

    @Override
    public List<String> obtenerRoles() throws IOException {

        File f = ResourceUtils.getFile("classpath:roles.txt");

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        List<String> roles = new ArrayList<>();
        String linea;

        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                roles.add(linea.trim());
            }
        }

        br.close();
        return roles;
    }

    @Override
    public List<DesplegableDTO> obtenerListaJugadores() throws IOException {

        File f = ResourceUtils.getFile("classpath:listaJugadores.txt");

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        List<DesplegableDTO> lista = new ArrayList<>();
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split("-");
            if (partes.length == 2) {
                lista.add(new DesplegableDTO(Integer.parseInt(partes[0].trim()),
                                             partes[1].trim()));
            }
        }

        br.close();
        return lista;
    }
}
