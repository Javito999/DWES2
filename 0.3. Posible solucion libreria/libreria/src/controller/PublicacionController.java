package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dtos.PublicacionDTO;
import model.PublicacionModelo;

public class PublicacionController {
    
    private PublicacionModelo modelo;
    
    public PublicacionController() {
        this.modelo = new PublicacionModelo();
    }
    
    public Integer insertarPublicacion(String idPublicacion, String titulo, String autor,
            short nroEdicion, double precio, int stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        return modelo.insertarPublicacion(idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);
    }
    
    public ArrayList<PublicacionDTO> listarPublicaciones(String idPublicacion, String titulo,
            String autor, String nroEdicion, Double precio, Integer stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        return modelo.listarPublicaciones(idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);
    }
    
    public Integer actualizarPublicacion(String idPublicacion, String titulo, String autor,
            Short nroEdicion, Double precio, Integer stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        return modelo.actualizarPublicacion(idPublicacion, titulo, autor, nroEdicion, precio, stock, idTipo);
    }
}
