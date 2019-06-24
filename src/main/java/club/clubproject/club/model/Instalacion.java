package club.clubproject.club.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "instalacion")
public class Instalacion {

	@Id
	private Integer id;
	
	@Column
	private String descripcion;
	
	@Column
	private BigDecimal precioPorHora;

	public Instalacion() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(BigDecimal precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
}