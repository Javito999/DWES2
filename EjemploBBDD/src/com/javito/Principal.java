package com.javito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Modelo.ClienteModelo;
import Utils.DBUtils;
import Vista.VistaClientes;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, java.sql.SQLException {

		ClienteModelo cm = new ClienteModelo();

		ArrayList<ClienteDTO> listaClientes = cm.recuperarNOmbreTelefono();
		System.out.println(listaClientes.get(8).getNombre());

		ArrayList<ClienteDTO> listaClientes2 = new ArrayList<ClienteDTO>();
		cm.recuperarNOmbreTelefonoFiltrado("a");

		System.out.println(listaClientes2.get(8).getNombre());

		VistaClientes vc = new VistaClientes();
		vc.menuRecuperaNombreTlfnFiltrarNOmbre();

	}

}
