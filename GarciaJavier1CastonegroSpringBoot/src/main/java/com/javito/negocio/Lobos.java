package com.javito.negocio;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.javito.ForEachComboSpringBoot.beans.Jugador;
import com.javito.modelo.IConsultaDatos;

@Component
public class Lobos implements ILobos {

	@Autowired
	private IConsultaDatos consulta;

	public Jugador asignarRol(int idJugador) throws IOException {

		String nombre = consulta.obtenerNombrePorId(idJugador);
		List<String> roles = consulta.obtenerRoles();

		Random random = new Random();
		String rol = roles.get(random.nextInt(roles.size()));

		String mensaje = obtenerMensajePersonalizado(rol);

		Jugador j = new Jugador();
		j.setIdJugador(idJugador);
		j.setNombreJugador(nombre);
		j.setRolJugador(rol + " — " + mensaje);

		return j;
	}

	private String obtenerMensajePersonalizado(String rol) {
		switch (rol) {
		case "lobo":
			return "¡Cuidado! Este personaje es un lobo";
		case "vidente":
			return "Este te mira mal si le matas.";
		case "campesino":
			return "Como coja la güadaña te reviento";
		case "cazador":
			return "Este personaje salvó a caperucita roja";
		default:
			return "Rol no especificado.";
		}

	}

	@Override
	public String asignarRol() {
		// TODO Auto-generated method stub
		return null;
	}
}
