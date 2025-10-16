package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import dtos.VentaDTO;
import model.VentaModelo;

public class VentaController {
    
    public Integer insertarVenta(VentaDTO venta) throws ClassNotFoundException, SQLException {
        VentaModelo vm = new VentaModelo();
        return vm.insertarVenta(venta);
    }
    
    public ArrayList<VentaDTO> recuperarVentas(Integer idVenta, Integer cantidad, 
            Double precio) throws ClassNotFoundException, SQLException {
        VentaModelo vm = new VentaModelo();
        return vm.recuperarVentas(idVenta, cantidad, precio);
    }
    
    public Integer actualizarVenta(VentaDTO venta) throws ClassNotFoundException, SQLException {
        VentaModelo vm = new VentaModelo();
        return vm.actualizarVenta(venta);
    }
    
    public Integer borrarVenta(int idVenta) throws ClassNotFoundException, SQLException {
        VentaModelo vm = new VentaModelo();
        return vm.borrarVenta(idVenta);
    }
}