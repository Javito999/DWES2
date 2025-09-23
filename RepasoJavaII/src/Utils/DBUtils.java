package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	public static Connection conexionBBDD() throws ClassNotFoundException,
	SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String servidor = "jdbc:mysql://localhost:3306/classicmodels"; // url de
	//conexión
	String username = "root"; // Usuario
	String password = "PracticaRoot"; // La contraseña de la BBDD
	Connection conexionBD = DriverManager.getConnection(servidor, username,
	password);
	return conexionBD;
	}
	
}
