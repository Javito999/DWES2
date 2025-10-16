package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    public static Connection conexionBBDD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String servidor = "jdbc:mysql://localhost:3306/libreria";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(servidor, username, password);
    }
}
