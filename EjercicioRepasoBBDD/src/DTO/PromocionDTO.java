package DTO;

public class PromocionDTO {

	private Integer idPromocion;
	private double cantMinima;
	private double cantMaxima;
	private double porcentaje;

	public PromocionDTO(Integer idPromocion, double cantMinima, double cantMaxima, double porcentaje) {
		super();
		this.idPromocion = idPromocion;
		this.cantMinima = cantMinima;
		this.cantMaxima = cantMaxima;
		this.porcentaje = porcentaje;
	}

	public Integer getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}

	public double getCantMinima() {
		return cantMinima;
	}

	public void setCantMinima(double cantMinima) {
		this.cantMinima = cantMinima;
	}

	public double getCantMaxima() {
		return cantMaxima;
	}

	public void setCantMaxima(double cantMaxima) {
		this.cantMaxima = cantMaxima;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
