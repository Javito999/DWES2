package Main;

import java.sql.SQLException;

import Vista.TipoVista;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		TipoVista tv = new TipoVista();

		tv.menuBusquedaPorFiltros();

	}

}
