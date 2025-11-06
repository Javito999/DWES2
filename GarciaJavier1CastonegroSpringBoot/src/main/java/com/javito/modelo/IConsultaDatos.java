package com.javito.modelo;

import java.io.IOException;
import java.util.List;

import com.javito.ForEachComboSpringBoot.beans.DesplegableDTO;

public interface IConsultaDatos {

    String obtenerNombrePorId(int idJugador) throws IOException;

    List<String> obtenerRoles() throws IOException;

	List<DesplegableDTO> obtenerListaJugadores() throws IOException;
}
