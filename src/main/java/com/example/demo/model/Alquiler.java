package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * Clase Alquiler con sus atributos.
 * @author fartorr0810
 *
 */
@Entity
public class Alquiler {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idalquiler;
	private Integer horasalquiler;
	private LocalDateTime horarecogida;
	private LocalDateTime horaentrega; 
	@ManyToOne(fetch=FetchType.EAGER)
	private Patinete patinete;
	@ManyToOne
	private User user;
	private Double preciototal;
	private Boolean entregado;
	private String codigoDescuento;
	//Constructores
	public Alquiler() {
		super();
		this.entregado=false;
	}

	public Alquiler(Integer horasalquiler, LocalDateTime horaentrega, Patinete patinete,User user,String codigoDescuento) {
		super();
		this.horasalquiler = horasalquiler;
		this.horaentrega = horaentrega;
		//Cuidado con esto.
		this.horarecogida=this.horarecogida.plusHours(horasalquiler);
		this.patinete = patinete;
		this.user=user;
		this.codigoDescuento=codigoDescuento;
	}

	public Alquiler(Integer idalquiler) {
		super();
		this.idalquiler = idalquiler;
	}
//	Getters y Setters
	public Integer getIdalquiler() {
		return idalquiler;
	}

	public void setIdalquiler(Integer idalquiler) {
		this.idalquiler = idalquiler;
	}

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

	public Patinete getPatinete() {
		return patinete;
	}

	public void setPatinete(Patinete patinete) {
		this.patinete = patinete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(Double preciototal) {
		this.preciototal = preciototal;
	}
public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public String getCodigo() {
		return codigoDescuento;
	}

	public void setCodigo(String codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}

	//HashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(idalquiler);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(idalquiler, other.idalquiler);
	}
	

}
