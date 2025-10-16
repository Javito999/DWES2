package controller;

import model.TipoModelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dtos.TipoDTO;

public class TipoController {
    private TipoModelo modelo;
    
    public TipoController() {
        this.modelo = new TipoModelo();
    }
    
    public Integer insertarTipo(String idTipo, String descripcion) throws ClassNotFoundException, SQLException {
        return modelo.insertarTipo(idTipo, descripcion);
    }
    
    public ArrayList<TipoDTO> consultarTipos(String idTipo, String descripcion) throws ClassNotFoundException, SQLException {
        return modelo.buscarTipos(idTipo, descripcion);
    }
    
    public Integer actualizarDescripcion(String idTipo, String nuevaDescripcion) throws ClassNotFoundException, SQLException {
        return modelo.actualizarTipo(idTipo, nuevaDescripcion);
    }
}
