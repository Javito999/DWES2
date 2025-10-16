package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.VentaController;
import dtos.VentaDTO;

public class VistaVenta {
    private BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    
    public void menuVenta() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
        int opcion;
        do {
            System.out.println("\n*** GESTIÓN DE VENTAS ***");
            System.out.println("1. Insertar venta");
            System.out.println("2. Buscar ventas");
            System.out.println("3. Actualizar venta");
            System.out.println("4. Eliminar venta");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = Integer.parseInt(leer.readLine());
            
            switch(opcion) {
                case 1: menuInsertarVenta(); break;
                case 2: menuBuscarVentas(); break;
                case 3: menuActualizarVenta(); break;
                case 4: menuBorrarVenta(); break;
                case 5: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }
    
    private void menuInsertarVenta() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n*** INSERTAR VENTA ***");
        System.out.println("ID Venta: ");
        int idVenta = Integer.parseInt(leer.readLine());
        System.out.println("Cliente: ");
        String cliente = leer.readLine();
        System.out.println("Fecha (YYYY-MM-DD): ");
        String fecha = leer.readLine();
        System.out.println("ID Empleado: ");
        int idEmpleado = Integer.parseInt(leer.readLine());
        System.out.println("ID Publicación: ");
        String idPublicacion = leer.readLine();
        System.out.println("Cantidad: ");
        int cantidad = Integer.parseInt(leer.readLine());
        System.out.println("Precio: ");
        double precio = Double.parseDouble(leer.readLine());
        System.out.println("Descuento: ");
        double dcto = Double.parseDouble(leer.readLine());
        System.out.println("Impuesto: ");
        double impuesto = Double.parseDouble(leer.readLine());
        
        VentaDTO venta = new VentaDTO(idVenta, cliente, fecha, idEmpleado, 
                                     idPublicacion, cantidad, precio, dcto, impuesto);
        
        VentaController vc = new VentaController();
        int resultado = vc.insertarVenta(venta);
        
        if (resultado == 1) {
            System.out.println("Venta insertada correctamente");
        } else {
            System.out.println("Error al insertar la venta");
        }
    }
    
    private void menuBuscarVentas() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n*** BUSCAR VENTAS ***");
        System.out.println("ID Venta (Enter para omitir): ");
        String idVentaStr = leer.readLine();
        Integer idVenta = idVentaStr.isEmpty() ? null : Integer.parseInt(idVentaStr);
        
        System.out.println("Cantidad mínima (Enter para omitir): ");
        String cantidadStr = leer.readLine();
        Integer cantidad = cantidadStr.isEmpty() ? null : Integer.parseInt(cantidadStr);
        
        System.out.println("Precio mínimo (Enter para omitir): ");
        String precioStr = leer.readLine();
        Double precio = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);
        
        VentaController vc = new VentaController();
        ArrayList<VentaDTO> ventas = vc.recuperarVentas(idVenta, cantidad, precio);
        
        if (ventas.isEmpty()) {
            System.out.println("No se encontraron ventas con esos criterios");
        } else {
            System.out.println("\nVentas encontradas:");
            System.out.printf("%-8s %-30s %-12s %-30s %-10s %-10s\n", 
                            "ID", "Empleado", "ID Pub", "Título", "Cantidad", "Precio");
            System.out.println("--------------------------------------------------------------------------------");
            
            for (VentaDTO v : ventas) {
                System.out.printf("%-8d %-30s %-12s %-30s %-10d %.2f\n",
                                v.getIdVenta(), v.getNombreEmpleado(), v.getIdPublicacion(),
                                v.getTituloPublicacion(), v.getCantidad(), v.getPrecio());
            }
        }
    }
    
    private void menuActualizarVenta() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n*** ACTUALIZAR VENTA ***");
        System.out.println("ID de la venta a actualizar: ");
        int idVenta = Integer.parseInt(leer.readLine());
        
        System.out.println("Cliente (Enter para no modificar): ");
        String cliente = leer.readLine();
        System.out.println("Fecha (YYYY-MM-DD) (Enter para no modificar): ");
        String fecha = leer.readLine();
        System.out.println("ID Empleado (0 para no modificar): ");
        int idEmpleado = Integer.parseInt(leer.readLine());
        System.out.println("ID Publicación (Enter para no modificar): ");
        String idPublicacion = leer.readLine();
        System.out.println("Cantidad (0 para no modificar): ");
        int cantidad = Integer.parseInt(leer.readLine());
        System.out.println("Precio (0 para no modificar): ");
        double precio = Double.parseDouble(leer.readLine());
        System.out.println("Descuento (0 para no modificar): ");
        double dcto = Double.parseDouble(leer.readLine());
        System.out.println("Impuesto (0 para no modificar): ");
        double impuesto = Double.parseDouble(leer.readLine());
        
        VentaDTO venta = new VentaDTO(idVenta, cliente, fecha, idEmpleado, 
                                     idPublicacion, cantidad, precio, dcto, impuesto);
        
        VentaController vc = new VentaController();
        int resultado = vc.actualizarVenta(venta);
        
        if (resultado == 1) {
            System.out.println("Venta actualizada correctamente");
        } else {
            System.out.println("Error al actualizar la venta");
        }
    }
    
    private void menuBorrarVenta() throws IOException, ClassNotFoundException, SQLException {
        System.out.println("\n*** ELIMINAR VENTA ***");
        System.out.println("ID de la venta a eliminar: ");
        int idVenta = Integer.parseInt(leer.readLine());
        
        VentaController vc = new VentaController();
        int resultado = vc.borrarVenta(idVenta);
        
        if (resultado == 1) {
            System.out.println("Venta eliminada correctamente");
        } else {
            System.out.println("Error al eliminar la venta o venta no encontrada");
        }
    }
}