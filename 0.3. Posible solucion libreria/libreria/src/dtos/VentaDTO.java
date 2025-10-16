package dtos;

public class VentaDTO {
    private int idVenta;
    private String cliente;
    private String fecha;
    private int idEmpleado;
    private String idPublicacion;
    private int cantidad;
    private double precio;
    private double dcto;
    private double impuesto;
    private String nombreEmpleado; // Para el listado
    private String tituloPublicacion; // Para el listado

    // Constructor para inserción
    public VentaDTO(int idVenta, String cliente, String fecha, int idEmpleado, 
                    String idPublicacion, int cantidad, double precio, 
                    double dcto, double impuesto) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.idPublicacion = idPublicacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dcto = dcto;
        this.impuesto = impuesto;
    }

    // Constructor para listado
    public VentaDTO(int idVenta, String nombreEmpleado, String idPublicacion, 
                    String tituloPublicacion, int cantidad, double precio) {
        this.idVenta = idVenta;
        this.nombreEmpleado = nombreEmpleado;
        this.idPublicacion = idPublicacion;
        this.tituloPublicacion = tituloPublicacion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters
    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }
    
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    
    public String getIdPublicacion() { return idPublicacion; }
    public void setIdPublicacion(String idPublicacion) { this.idPublicacion = idPublicacion; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public double getDcto() { return dcto; }
    public void setDcto(double dcto) { this.dcto = dcto; }
    
    public double getImpuesto() { return impuesto; }
    public void setImpuesto(double impuesto) { this.impuesto = impuesto; }
    
    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    
    public String getTituloPublicacion() { return tituloPublicacion; }
    public void setTituloPublicacion(String tituloPublicacion) { this.tituloPublicacion = tituloPublicacion; }
}