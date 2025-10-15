package com.javito.modelo;

import java.util.Random;

public class DescuentoModelo {
	
	public int generadescuento() {
		Random random = new Random();
		
		return random.nextInt(20) + 2;
	}

}
