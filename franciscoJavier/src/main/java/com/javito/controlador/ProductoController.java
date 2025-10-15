package com.javito.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductoController {
	@RequestMapping(value="producto")
	public String Producto() {
		return "producto";
	}
}
