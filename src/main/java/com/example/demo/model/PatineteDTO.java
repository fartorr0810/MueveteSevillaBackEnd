package com.example.demo.model;

public class PatineteDTO {
	private Integer idpatinete;
	private String modelo;
	private Double precioHora;
	private Boolean disponible;
	private Double kmhora;
	private byte[] imagen;
	
	
	public PatineteDTO() {
		super();
	}

	public PatineteDTO(String modelo, Double precioHora, Double kmhora,byte[] imagen) {
		super();
		this.modelo = modelo;
		this.precioHora = precioHora;
		this.kmhora = kmhora;
		this.imagen=imagen;
		this.disponible=true;
	}


	public Integer getIdpatinete() {
		return idpatinete;
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


	public Double getKmhora() {
		return kmhora;
	}


	public void setKmhora(Double kmhora) {
		this.kmhora = kmhora;
	}


	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	
	
	}
