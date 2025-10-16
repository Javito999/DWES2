package com.javito.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javito.modelo.DescuentoModelo;

@Controller
public class DescuentoController {

	@RequestMapping(value = "/descuento")

	public String obtenerDescuento(Model model) {
		DescuentoModelo dm = new DescuentoModelo();

		int num = dm.generadescuento();

		model.addAttribute("descuentoGenerado", num);

		return "descuento";

	}
}
