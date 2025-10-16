package dtos;

public class PublicacionDTO {
    private String idPublicacion;
    private String titulo;
    private String autor;
    private int nroEdicion;
    private double precio;
    private int stock;
    private String idTipo;
    private String descripcionTipo; // Para mostrar la descripción del tipo

    public PublicacionDTO(String idPublicacion, String titulo, String autor, 
                         int nroEdicion, double precio, int stock, String idTipo, String descripcionTipo) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.autor = autor;
        this.nroEdicion = nroEdicion;
        this.precio = precio;
        this.stock = stock;
        this.idTipo = idTipo;
        this.descripcionTipo = descripcionTipo;
    }

	public String getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(String idPublicacion) {
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

	public int getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

   
}