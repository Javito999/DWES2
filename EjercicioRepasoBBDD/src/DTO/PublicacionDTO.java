package DTO;

public class PublicacionDTO {

	private Integer idPublicacion;
	private String titulo;
	private String autor;
	private Integer numeroEdicion;
	private double precio;
	private boolean stock;

	public PublicacionDTO(Integer idPublicacion, String titulo, String autor, Integer numeroEdicion, double precio,
			boolean stock) {
		super();
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroEdicion = numeroEdicion;
		this.precio = precio;
		this.stock = stock;
	}

	public Integer getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroEdicion() {
		return numeroEdicion;
	}

	public void setNumeroEdicion(Integer numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

 }
