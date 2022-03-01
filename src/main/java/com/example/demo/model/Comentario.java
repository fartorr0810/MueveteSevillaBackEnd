package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Clase comentario con sus atributos
 * @author estudiante
 *
 */
@Entity
public class Comentario {
	//Atributos
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcomentario;
	private String email;
	private String telefono;
	private String contenidocomentario;

	//constructores
	public Comentario() {
		super();
	}
	public Comentario(String email, String telefono, String contenidocomentario) {
		super();
		this.email = email;
		this.telefono = telefono;
		this.contenidocomentario = contenidocomentario;
	}

	public String getContenidocomentario() {
		return contenidocomentario;
	}

	public void setContenidocomentario(String contenidocomentario) {
		this.contenidocomentario = contenidocomentario;
	}
	public Integer getIdcomentario() {
		return idcomentario;
	}
	public void setIdcomentario(Integer idcomentario) {
		this.idcomentario = idcomentario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idcomentario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(idcomentario, other.idcomentario);
	}
	
}
