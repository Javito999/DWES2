package com.javito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Modelo.ClienteModelo;
import Utils.DBUtils;

public class Principal {

	private static final String SQLException = null;

	public static void main(String[] args) throws ClassNotFoundException, java.sql.SQLException {

		ClienteModelo cm = new ClienteModelo();
		
		ArrayList<ClienteDTO> listaClientes = 
				cm.recuperarNOmbreTelefono();
		System.out.println(listaClientes.get(0).getNombre());

	}

}
