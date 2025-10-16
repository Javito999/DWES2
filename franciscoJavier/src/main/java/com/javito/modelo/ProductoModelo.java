package com.javito.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class ProductoModelo {

	public String productoDestacado() {

		String[] productos = { "Leche", "Huevos", "Aceite", "Pañuelos", "Pilas", "Caramelos" };

		int indicealeatorio = numeroaleatorioArray(0, productos.length - 1);

		String productoAleatorio = productos[indicealeatorio];

		return productoAleatorio;

	}

	public int numeroaleatorioArray(int minimo, int maximo) {

		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);

	}

}
