package com.javito.controlador;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javito.modelo.Persona;

@Controller
public class PersonaController {

	@GetMapping("/obtenerpersona")
	
	public String obtenerPersona(Model model) {
		Persona p = new Persona(28, "javi");
		
		model.addAttribute("persona", p);
		
		ArrayList<String> listaDeEquipos = new ArrayList<>();
		listaDeEquipos.add("Ferrari");
		listaDeEquipos.add("Aston Martin");
		listaDeEquipos.add("McLaren");
		
		model.addAttribute("listaEquipos", listaDeEquipos);
		
	
		// Creamos una lista de personas
		ArrayList<Persona> listaDePersonas = new ArrayList<>();
		listaDePersonas.add(new Persona(24, "Piastri"));
		listaDePersonas.add(new Persona(40, "Hamilton"));
		listaDePersonas.add(new Persona(28, "Verstappen"));

		model.addAttribute("listaPersonas", listaDePersonas);
		
		return "personas";
		
	}
}
