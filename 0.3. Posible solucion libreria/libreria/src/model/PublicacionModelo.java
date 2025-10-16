package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dtos.PublicacionDTO;
import utils.DBUtils;

public class PublicacionModelo {
	 // Método para insertar una publicación
    public Integer insertarPublicacion(String idPublicacion, String titulo, String autor, 
            short nroEdicion, double precio, int stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        
        String sql = "INSERT INTO publicacion (idpublicacion, titulo, autor, nroedicion, precio, stock, idtipo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = DBUtils.conexionBBDD();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, idPublicacion);
            ps.setString(2, titulo);
            ps.setString(3, autor);
            ps.setShort(4, nroEdicion);
            ps.setDouble(5, precio);
            ps.setInt(6, stock);
            ps.setString(7, idTipo);
            
            return ps.executeUpdate();
        }
    }
    
    // Método para listar publicaciones con filtros
    public ArrayList<PublicacionDTO> listarPublicaciones(String idPublicacion, String titulo, 
            String autor, String nroEdicion, Double precio, Integer stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        
        StringBuilder sql = new StringBuilder(
            "SELECT p.*, t.descripcion FROM publicacion p "
            + "INNER JOIN tipo t ON p.idtipo = t.idtipo WHERE 1=1 ");
        
        ArrayList<Object> parametros = new ArrayList<>();
        
        if (idPublicacion != null && !idPublicacion.isEmpty()) {
            sql.append("AND p.idpublicacion = ? ");
            parametros.add(idPublicacion);
        }
        if (titulo != null && !titulo.isEmpty()) {
            sql.append("AND p.titulo LIKE ? ");
            parametros.add("%" + titulo + "%");
        }
        if (autor != null && !autor.isEmpty()) {
            sql.append("AND p.autor LIKE ? ");
            parametros.add("%" + autor + "%");
        }
        if (nroEdicion != null && !nroEdicion.isEmpty()) {
            sql.append("AND p.nroedicion LIKE ? ");
            parametros.add("%" + nroEdicion + "%");
        }
        if (precio != null) {
            sql.append("AND p.precio >= ? ");
            parametros.add(precio);
        }
        if (stock != null) {
            sql.append("AND p.stock >= ? ");
            parametros.add(stock);
        }
        if (idTipo != null && !idTipo.isEmpty()) {
            sql.append("AND p.idtipo = ? ");
            parametros.add(idTipo);
        }
        
        ArrayList<PublicacionDTO> listaPublicaciones = new ArrayList<>();
        
        try (Connection conexion = DBUtils.conexionBBDD();
             PreparedStatement ps = conexion.prepareStatement(sql.toString())) {
            
            for (int i = 0; i < parametros.size(); i++) {
                ps.setObject(i + 1, parametros.get(i));
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PublicacionDTO p = new PublicacionDTO(
                    rs.getString("idpublicacion"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("nroedicion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("idtipo"),
                    rs.getString("descripcion")
                );
                listaPublicaciones.add(p);
            }
        }
        return listaPublicaciones;
    }
    
    // Método para actualizar una publicación
    public Integer actualizarPublicacion(String idPublicacion, String titulo, String autor,
            Short nroEdicion, Double precio, Integer stock, String idTipo) 
            throws ClassNotFoundException, SQLException {
        
        StringBuilder sql = new StringBuilder("UPDATE publicacion SET ");
        ArrayList<Object> parametros = new ArrayList<>();
        boolean primero = true;
        
        if (titulo != null && !titulo.isEmpty()) {
            sql.append(primero ? "" : ", ").append("titulo = ?");
            parametros.add(titulo);
            primero = false;
        }
        if (autor != null && !autor.isEmpty()) {
            sql.append(primero ? "" : ", ").append("autor = ?");
            parametros.add(autor);
            primero = false;
        }
        if (nroEdicion != null) {
            sql.append(primero ? "" : ", ").append("nroedicion = ?");
            parametros.add(nroEdicion);
            primero = false;
        }
        if (precio != null) {
            sql.append(primero ? "" : ", ").append("precio = ?");
            parametros.add(precio);
            primero = false;
        }
        if (stock != null) {
            sql.append(primero ? "" : ", ").append("stock = ?");
            parametros.add(stock);
            primero = false;
        }
        if (idTipo != null && !idTipo.isEmpty()) {
            sql.append(primero ? "" : ", ").append("idtipo = ?");
            parametros.add(idTipo);
            primero = false;
        }
        
        sql.append(" WHERE idpublicacion = ?");
        parametros.add(idPublicacion);
        
        try (Connection conexion = DBUtils.conexionBBDD();
             PreparedStatement ps = conexion.prepareStatement(sql.toString())) {
            
            for (int i = 0; i < parametros.size(); i++) {
                ps.setObject(i + 1, parametros.get(i));
            }
            
            return ps.executeUpdate();
        }
    }

}
