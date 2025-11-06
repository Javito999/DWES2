package com.javito.ForEachComboSpringBoot.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/listaJugadores")
	public String listajugadores(Model model) {

		return null;

	}

}
