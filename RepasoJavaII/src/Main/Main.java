package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ClienteDTO;
import Model.ClienteModelo;
import Utils.DBUtils;
import Vista.VistaClientes;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		VistaClientes vc = new VistaClientes();
		vc.menuRecuperaNOmbreTelefono();

	}

}
