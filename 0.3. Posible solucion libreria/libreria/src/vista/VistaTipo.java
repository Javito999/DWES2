package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.TipoController;
import dtos.TipoDTO;

public class VistaTipo {
    private TipoController controller;
    private BufferedReader reader;
    
    public VistaTipo() {
        this.controller = new TipoController();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void mostrarMenuTipo() throws IOException, ClassNotFoundException, SQLException {
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
                    	menuConsultarTipos();
                        break;
                    case 2:
                        menuInsertarTipo();
                        break;
                    case 3:
                    	menuActualizarTipo();
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
    
    public void menuInsertarTipo() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n-- INSERTAR NUEVO TIPO --");
        System.out.println("Introduce el ID del tipo (3 caracteres):");
        String idTipo = reader.readLine();
        
        System.out.println("Introduce la descripción:");
        String descripcion = reader.readLine();
        
        Integer resultado = controller.insertarTipo(idTipo, descripcion);
        
        if(resultado == 1) {
            System.out.println("Tipo insertado correctamente");
        } else {
            System.out.println("Error al insertar el tipo");
        }
    }
    
    public void menuConsultarTipos() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n-- CONSULTAR TIPOS --");
        System.out.println("Introduce el ID del tipo (pulsa Enter para omitir):");
        String idTipo = reader.readLine();
        
        System.out.println("Introduce la descripción (pulsa Enter para omitir):");
        String descripcion = reader.readLine();
        
        ArrayList<TipoDTO> tipos = controller.consultarTipos(
            idTipo.isBlank() ? null : idTipo,
            descripcion.isBlank() ? null : descripcion
        );
        
        if(tipos.isEmpty()) {
            System.out.println("No se encontraron tipos");
        } else {
            System.out.println("\nResultados encontrados:");
            System.out.printf("%-5s | %-30s%n", "ID", "Descripción");
            System.out.println("-".repeat(40));
            
            for(TipoDTO tipo : tipos) {
                System.out.printf("%-5s | %-30s%n", 
                    tipo.getIdTipo(), 
                    tipo.getDescripcion());
            }
        }
    }
    
    public void menuActualizarTipo() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n-- ACTUALIZAR TIPO --");
        System.out.println("Introduce el ID del tipo a actualizar:");
        String idTipo = reader.readLine();
        
        System.out.println("Introduce la nueva descripción:");
        String nuevaDescripcion = reader.readLine();
        
        Integer resultado = controller.actualizarDescripcion(idTipo, nuevaDescripcion);
        
        if(resultado == 1) {
            System.out.println("Tipo actualizado correctamente");
        } else {
            System.out.println("Error al actualizar el tipo o ID no encontrado");
        }
    }
}