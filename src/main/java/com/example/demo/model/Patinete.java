package com.example.demo.model;

import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
/**
 * Model patinete
 * @author fartorr0810
 *
 */
@Entity
public class Patinete {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpatinete;
	private String modelo;
	private Double precioHora;
	private Boolean disponible;
	private Double kmhora;
	@Lob
	private byte[] imagen;
	
	//Constructores
	public Patinete() {
		super();
	}
	
	public Patinete(String modelo, Double precioHora, Boolean disponible, Double kmhora,byte[] imagen) {
		super();
		this.modelo = modelo;
		this.precioHora = precioHora;
		this.disponible = disponible;
		this.kmhora = kmhora;
		this.imagen=imagen;
		
	}

	public Patinete(Integer idpatinete) {
		super();
		this.idpatinete = idpatinete;
	}

	//Getters y Setters
	public Integer getIdpatinete() {
		return idpatinete;
	}
	public Double getKmhora() {
		return kmhora;
	}
	public void setKmhora(Double kmhora) {
		this.kmhora = kmhora;
	}

	public void setIdpatinete(Integer idpatinete) {
		this.idpatinete = idpatinete;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	//HashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(idpatinete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patinete other = (Patinete) obj;
		return Objects.equals(idpatinete, other.idpatinete);
	}
	
	
}
