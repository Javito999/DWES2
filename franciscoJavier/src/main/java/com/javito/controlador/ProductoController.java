package com.javito.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javito.modelo.ProductoModelo;

@Controller
public class ProductoController {
	
	@RequestMapping(value="producto")
	
	
	public String Producto(Model model) {
		
		ProductoModelo pm = new ProductoModelo();
		
		String productoDia = pm.productoDestacado();
		
		model.addAttribute("productoAleatorio", productoDia);
		
		return "producto";
	}
}
