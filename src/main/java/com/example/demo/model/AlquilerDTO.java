package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
/**
 * Clase Alquiler DTO para devolver a la parte de front la informacion que debe ver
 * y no el alquiler completo.
 * @author fartorr0810
 *
 */
public class AlquilerDTO {
	//Atributos
	private Integer idalquiler;
	private Integer horasalquiler;
	private LocalDateTime horarecogida;
	private LocalDateTime horaentrega;
	private Double preciototal;
	private String modelo;
	private Boolean entregado;
	private String codigoDescuento;
	//Constructores
	public AlquilerDTO() {
		super();
	}
	
	public AlquilerDTO(Integer horasalquiler, LocalDateTime horarecogida, LocalDateTime horaentrega
			,String codigoDescuento) {
		super();
		this.horasalquiler = horasalquiler;
		this.horarecogida = horarecogida;
		this.horaentrega = horaentrega;
		this.codigoDescuento=codigoDescuento;
	}
	//Getters y Setters
	public Integer getHorasalquiler() {
		return horasalquiler;
	}
	public void setHorasalquiler(Integer horasalquiler) {
		this.horasalquiler = horasalquiler;
	}
	public LocalDateTime getHorarecogida() {
		return horarecogida;
	}
	public void setHorarecogida(LocalDateTime horarecogida) {
		this.horarecogida = horarecogida;
	}
	public LocalDateTime getHoraentrega() {
		return horaentrega;
	}
	public void setHoraentrega(LocalDateTime horaentrega) {
		this.horaentrega = horaentrega;
	}
	public Double getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(Double preciototal) {
		this.preciototal = preciototal;
	}
public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public Integer getIdalquiler() {
		return idalquiler;
	}

	public void setIdalquiler(Integer idalquiler) {
		this.idalquiler = idalquiler;
	}

	public String getCodigoDescuento() {
		return codigoDescuento;
	}

	public void setCodigoDescuento(String codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}

	//	HashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(horaentrega, horarecogida, horasalquiler);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlquilerDTO other = (AlquilerDTO) obj;
		return Objects.equals(horaentrega, other.horaentrega) && Objects.equals(horarecogida, other.horarecogida)
				&& Objects.equals(horasalquiler, other.horasalquiler);
	}
	
}
