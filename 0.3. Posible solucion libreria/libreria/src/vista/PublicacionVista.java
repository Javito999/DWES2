package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.PublicacionController;
import dtos.PublicacionDTO;

public class PublicacionVista {
    
    private PublicacionController controlador;
    private BufferedReader reader;
    
    public PublicacionVista() {
        this.controlador = new PublicacionController();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void mostrarMenuPublicacion() throws IOException, ClassNotFoundException, SQLException {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PUBLICACIONES ===");
            System.out.println("1. Listar publicaciones");
            System.out.println("2. Insertar publicación");
            System.out.println("3. Actualizar publicación");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(reader.readLine());
                switch (opcion) {
                    case 1:
                        menuListarPublicaciones();
                        break;
                    case 2:
                        menuInsertarPublicacion();
                        break;
                    case 3:
                        menuActualizarPublicacion();
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
                opcion = 0;
            }
        } while (opcion != 4);
    }
    
    public void menuInsertarPublicacion() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n=== INSERTAR NUEVA PUBLICACIÓN ===");
        
        System.out.println("Introduce el ID de la publicación:");
        String idPublicacion = reader.readLine();
        
        System.out.println("Introduce el título:");
        String titulo = reader.readLine();
        
        System.out.println("Introduce el autor:");
        String autor = reader.readLine();
        
        System.out.println("Introduce el número de edición:");
        short nroEdicion = Short.parseShort(reader.readLine());
        
        System.out.println("Introduce el precio:");
        double precio = Double.parseDouble(reader.readLine());
        
        System.out.println("Introduce el stock:");
        int stock = Integer.parseInt(reader.readLine());
        
        System.out.println("Introduce el ID del tipo (LIB/REV/COM):");
        String idTipo = reader.readLine();
        
        Integer resultado = controlador.insertarPublicacion(idPublicacion, titulo, autor, 
                nroEdicion, precio, stock, idTipo);
        
        if (resultado == 1) {
            System.out.println("Publicación insertada correctamente");
        } else {
            System.out.println("Error al insertar la publicación");
        }
    }
    
    public void menuListarPublicaciones() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n=== BUSCAR PUBLICACIONES ===");
        
        System.out.println("ID de publicación (Enter para omitir):");
        String idPublicacion = reader.readLine();
        
        System.out.println("Título (Enter para omitir):");
        String titulo = reader.readLine();
        
        System.out.println("Autor (Enter para omitir):");
        String autor = reader.readLine();
        
        System.out.println("Número de edición (Enter para omitir):");
        String nroEdicion = reader.readLine();
        
        System.out.println("Precio mínimo (Enter para omitir):");
        String precioStr = reader.readLine();
        Double precio = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);
        
        System.out.println("Stock mínimo (Enter para omitir):");
        String stockStr = reader.readLine();
        Integer stock = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);
        
        System.out.println("ID del tipo (Enter para omitir):");
        String idTipo = reader.readLine();
        
        ArrayList<PublicacionDTO> publicaciones = controlador.listarPublicaciones(
                idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);
        
        if (publicaciones.isEmpty()) {
            System.out.println("No se encontraron publicaciones con los criterios especificados");
        } else {
            System.out.println("\nPublicaciones encontradas:");
            System.out.printf("%-10s %-30s %-20s %-10s %-10s %-10s %-15s%n",
                    "ID", "TÍTULO", "AUTOR", "EDICIÓN", "PRECIO", "STOCK", "TIPO");
            System.out.println("=".repeat(105));
            
            for (PublicacionDTO p : publicaciones) {
                System.out.printf("%-10s %-30s %-20s %-10d %-10.2f %-10d %-15s%n",
                        p.getIdPublicacion(),
                        p.getTitulo(),
                        p.getAutor(),
                        p.getNroEdicion(),
                        p.getPrecio(),
                        p.getStock(),
                        p.getDescripcionTipo());
            }
        }
    }
    
    public void menuActualizarPublicacion() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n=== ACTUALIZAR PUBLICACIÓN ===");
        
        System.out.println("Introduce el ID de la publicación a actualizar:");
        String idPublicacion = reader.readLine();
        
        System.out.println("Introduce el nuevo título (Enter para no modificar):");
        String titulo = reader.readLine();
        
        System.out.println("Introduce el nuevo autor (Enter para no modificar):");
        String autor = reader.readLine();
        
        System.out.println("Introduce el nuevo número de edición (Enter para no modificar):");
        String nroEdicionStr = reader.readLine();
        Short nroEdicion = nroEdicionStr.isEmpty() ? null : Short.parseShort(nroEdicionStr);
        
        System.out.println("Introduce el nuevo precio (Enter para no modificar):");
        String precioStr = reader.readLine();
        Double precio = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);
        
        System.out.println("Introduce el nuevo stock (Enter para no modificar):");
        String stockStr = reader.readLine();
        Integer stock = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);
        
        System.out.println("Introduce el nuevo ID del tipo (Enter para no modificar):");
        String idTipo = reader.readLine();
        
        Integer resultado = controlador.actualizarPublicacion(idPublicacion, titulo, autor,
                nroEdicion, precio, stock, idTipo);
        
        if (resultado == 1) {
            System.out.println("Publicación actualizada correctamente");
        } else {
            System.out.println("No se encontró la publicación o hubo un error al actualizar");
        }
    }
}