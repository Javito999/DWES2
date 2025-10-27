package com.javito.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javito.negocio.ICartas;

@Controller
public class Controlador {

	@Autowired
	ICartas cartas;

	@PostMapping("/cartas")
	public String controlador(@RequestParam("nombre") String nombre, Model model) throws IOException {

		double numCartas = cartas.muestraCartas(nombre);

		model.addAttribute("cartas", numCartas);
		model.addAttribute("nombre", nombre);

		return "cartas";

	}

}
