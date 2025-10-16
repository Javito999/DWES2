import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import vista.PublicacionVista;
import vista.VistaTipo;
import vista.VistaVenta;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        
        do {
            System.out.println("\n*** MENÚ PRINCIPAL ***");
            System.out.println("1. Gestión de Tipos");
            System.out.println("2. Gestión de Publicaciones");
            System.out.println("3. Gestión de Ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = Integer.parseInt(leer.readLine());
            
            switch(opcion) {
                case 1:
                    VistaTipo vt = new VistaTipo();
                    vt.mostrarMenuTipo();
                    break;
                case 2:
                	PublicacionVista vp = new PublicacionVista();
                    vp.mostrarMenuPublicacion();
                    break;
                case 3:
                    VistaVenta vv = new VistaVenta();
                    vv.menuVenta();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }
}