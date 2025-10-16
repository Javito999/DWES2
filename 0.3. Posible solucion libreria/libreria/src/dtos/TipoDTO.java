package dtos;

public class TipoDTO {
    private String idTipo;
    private String descripcion;

    public TipoDTO(String idTipo, String descripcion) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getIdTipo() { return idTipo; }
    public void setIdTipo(String idTipo) { this.idTipo = idTipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}