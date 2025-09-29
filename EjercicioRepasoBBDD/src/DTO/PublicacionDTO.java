package DTO;

public class PublicacionDTO {

	private String idTipo;
	private int idPublicacion;
	private String titulo;
	private String autor;
	private int numeroEdicion;
	private int precio;
	private int stock;

	public PublicacionDTO(String idTipo, int idPublicacion, String titulo, String autor, int numeroEdicion, int precio,
			int stock) {
		super();
		this.idTipo = idTipo;
		this.idPublicacion = idPublicacion;
		this.titulo = titulo;
		this.autor = autor;
		this.numeroEdicion = numeroEdicion;
		this.precio = precio;
		this.stock = stock;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
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

	public int getNumeroEdicion() {
		return numeroEdicion;
	}

	public void setNumeroEdicion(int numeroEdicion) {
		this.numeroEdicion = numeroEdicion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int isStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
