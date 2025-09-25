package DTO;

public class VentaDTO {
	
	private Integer idVenta;
	private String nombreCliente;
	private String fecha;
	private Integer idEmpleado;
	private Integer idPublicacion;
	private Integer cantidad;
	private double precio;
	private double descuento;
	private double impuesto;
	
	public VentaDTO(Integer idVenta, String nombreCliente, String fecha, Integer idEmpleado, Integer idPublicacion,
			Integer cantidad, double precio, double descuento, double impuesto) {
		super();
		this.idVenta = idVenta;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.idEmpleado = idEmpleado;
		this.idPublicacion = idPublicacion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descuento = descuento;
		this.impuesto = impuesto;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
	

}
