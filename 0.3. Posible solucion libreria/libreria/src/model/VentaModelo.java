package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dtos.VentaDTO;
import utils.DBUtils;

public class VentaModelo {
    
    public Integer insertarVenta(VentaDTO venta) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO venta (idventa, cliente, fecha, idempleado, idpublicacion, " +
                    "cantidad, precio, dcto, impuesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
        Connection connection = DBUtils.conexionBBDD();
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setInt(1, venta.getIdVenta());
        ps.setString(2, venta.getCliente());
        ps.setString(3, venta.getFecha());
        ps.setInt(4, venta.getIdEmpleado());
        ps.setString(5, venta.getIdPublicacion());
        ps.setInt(6, venta.getCantidad());
        ps.setDouble(7, venta.getPrecio());
        ps.setDouble(8, venta.getDcto());
        ps.setDouble(9, venta.getImpuesto());
        
        Integer resultado = ps.executeUpdate();
        connection.close();
        return resultado;
    }

    public ArrayList<VentaDTO> recuperarVentas(Integer idVenta, Integer cantidad, 
            Double precio) throws ClassNotFoundException, SQLException {
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT v.idventa, CONCAT(e.nombre, ' ', e.apellido) as nombre_empleado, ");
        query.append("v.idpublicacion, p.titulo, v.cantidad, v.precio ");
        query.append("FROM venta v ");
        query.append("INNER JOIN empleado e ON v.idempleado = e.idempleado ");
        query.append("INNER JOIN publicacion p ON v.idpublicacion = p.idpublicacion ");
        query.append("WHERE 1=1 ");

        if (idVenta != null) {
            query.append("AND v.idventa = ? ");
        }
        if (cantidad != null) {
            query.append("AND v.cantidad >= ? ");
        }
        if (precio != null) {
            query.append("AND v.precio >= ? ");
        }

        Connection connection = DBUtils.conexionBBDD();
        PreparedStatement ps = connection.prepareStatement(query.toString());
        
        int parameterIndex = 1;
        if (idVenta != null) ps.setInt(parameterIndex++, idVenta);
        if (cantidad != null) ps.setInt(parameterIndex++, cantidad);
        if (precio != null) ps.setDouble(parameterIndex, precio);

        ResultSet rs = ps.executeQuery();
        ArrayList<VentaDTO> listaVentas = new ArrayList<>();
        
        while (rs.next()) {
            VentaDTO v = new VentaDTO(
                rs.getInt("idventa"),
                rs.getString("nombre_empleado"),
                rs.getString("idpublicacion"),
                rs.getString("titulo"),
                rs.getInt("cantidad"),
                rs.getDouble("precio")
            );
            listaVentas.add(v);
        }
        
        connection.close();
        return listaVentas;
    }

    public Integer actualizarVenta(VentaDTO venta) throws ClassNotFoundException, SQLException {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE venta SET ");
        query.append("cliente = CASE WHEN ? = '' THEN cliente ELSE ? END, ");
        query.append("fecha = CASE WHEN ? = '' THEN fecha ELSE ? END, ");
        query.append("idempleado = CASE WHEN ? = 0 THEN idempleado ELSE ? END, ");
        query.append("idpublicacion = CASE WHEN ? = '' THEN idpublicacion ELSE ? END, ");
        query.append("cantidad = CASE WHEN ? = 0 THEN cantidad ELSE ? END, ");
        query.append("precio = CASE WHEN ? = 0 THEN precio ELSE ? END, ");
        query.append("dcto = CASE WHEN ? = 0 THEN dcto ELSE ? END, ");
        query.append("impuesto = CASE WHEN ? = 0 THEN impuesto ELSE ? END ");
        query.append("WHERE idventa = ?");

        Connection connection = DBUtils.conexionBBDD();
        PreparedStatement ps = connection.prepareStatement(query.toString());
        
        ps.setString(1, venta.getCliente());
        ps.setString(2, venta.getCliente());
        ps.setString(3, venta.getFecha());
        ps.setString(4, venta.getFecha());
        ps.setInt(5, venta.getIdEmpleado());
        ps.setInt(6, venta.getIdEmpleado());
        ps.setString(7, venta.getIdPublicacion());
        ps.setString(8, venta.getIdPublicacion());
        ps.setInt(9, venta.getCantidad());
        ps.setInt(10, venta.getCantidad());
        ps.setDouble(11, venta.getPrecio());
        ps.setDouble(12, venta.getPrecio());
        ps.setDouble(13, venta.getDcto());
        ps.setDouble(14, venta.getDcto());
        ps.setDouble(15, venta.getImpuesto());
        ps.setDouble(16, venta.getImpuesto());
        ps.setInt(17, venta.getIdVenta());

        Integer resultado = ps.executeUpdate();
        connection.close();
        return resultado;
    }

    public Integer borrarVenta(int idVenta) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM venta WHERE idventa = ?";
        
        Connection connection = DBUtils.conexionBBDD();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idVenta);
        
        Integer resultado = ps.executeUpdate();
        connection.close();
        return resultado;
    }
}