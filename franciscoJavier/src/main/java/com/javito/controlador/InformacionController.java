package com.javito.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformacionController {
	@RequestMapping(value="/info")
	public String Informacion() {
		return "informacion";
	}
}
