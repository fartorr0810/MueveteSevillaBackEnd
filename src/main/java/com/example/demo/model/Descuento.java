package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Descuento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iddescuento;
	private String codigo;
	private String nombrePromocion;
	private Double precioalDescontado;
	private Integer usos;
	public Descuento() {
		super();
	}
	
	public Descuento(String codigo, String nombrePromocion, Double precioalDescontado,Integer usos) {
		super();
		this.codigo = codigo;
		this.nombrePromocion = nombrePromocion;
		this.precioalDescontado = precioalDescontado;
		this.usos=usos;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombrePromocion() {
		return nombrePromocion;
	}
	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}
	public Double getPrecioalDescontado() {
		return precioalDescontado;
	}
	public void setPrecioalDescontado(Double precioalDescontado) {
		this.precioalDescontado = precioalDescontado;
	}

	public Integer getIddescuento() {
		return iddescuento;
	}

	public Integer getUsos() {
		return usos;
	}

	public void setUsos(Integer usos) {
		this.usos = usos;
	}

	public void setIddescuento(Integer iddescuento) {
		this.iddescuento = iddescuento;
	}
	
	
}
