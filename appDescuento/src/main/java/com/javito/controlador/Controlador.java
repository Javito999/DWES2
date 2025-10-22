package com.javito.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javito.negocio.IDescuento;

@Controller
public class Controlador {

	@Autowired
	IDescuento descuento;
	
	@PostMapping("/descuento")
	public String controlador(@RequestParam("nombre") String nombre, Model model) throws IOException{
		
		int cantidad = descuento.calculaDescuento(nombre);
		
		model.addAttribute("descuento", cantidad);
		model.addAttribute("nombre", nombre);
		
		
		return "descuento";
		
		
	}
	
	
}
