package com.javito.ForEachComboSpringBoot.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javito.ForEachComboSpringBoot.beans.DesplegableDTO;
import com.javito.ForEachComboSpringBoot.beans.Jugador;
import com.javito.modelo.IConsultaDatos;
import com.javito.negocio.Lobos;

@Controller
public class Controlador {
	@Autowired
	private IConsultaDatos consulta;

	@Autowired
	private Lobos servicio;

	@GetMapping({ "/", "/listaJugadores" })
	public String lista(Model model) throws IOException {

		List<DesplegableDTO> jugadores = consulta.obtenerListaJugadores();
		model.addAttribute("jugadores", jugadores);

		return "listaJugadores";
	}

	@PostMapping("/asignarRol")
	public String asignar(@RequestParam int idJugador, Model model) throws IOException {

		List<DesplegableDTO> jugadores = consulta.obtenerListaJugadores();
		model.addAttribute("jugadores", jugadores);

		Jugador j = servicio.asignarRol(idJugador);

		model.addAttribute("nombre", j.getNombreJugador());
		model.addAttribute("rol", j.getRolJugador());

		return "listaJugadores";
	}

}
