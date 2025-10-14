package com.javito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javito.modelo.GeneradorNumero;

@Controller
public class HolaController {
	@RequestMapping(value="/hola")
	public String Hola() {
		
		return "saludo";
	}
	
	@RequestMapping(value="/aleatorio")
	public String obtenerAleatorio(Model model) {
		// 1. Crear una nueva instancia de la clase de utilidad
		GeneradorNumero generador = new GeneradorNumero();
		// 2. Llamar al método para obtener el número
		int num = generador.generar();
		// 3. Pasar el dato a la vista
		model.addAttribute("numeroGenerado", num);
		// 4. Devolver el nombre de la vista
		return "numero";
		}

}
