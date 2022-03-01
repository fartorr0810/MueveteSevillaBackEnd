package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * Model User
 * @author fartorr0810
 *
 */
@Entity
public class User {
	//Atributos
		//Id autogenerada.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="email",unique=true)
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String nombre;
	private String nickname;
	private String rol;
	@OneToMany
	@JsonIgnore
	private Set<Alquiler> listaalquiler;
	
	//Constructores
	public User() {
		super();
	}
	//Construcctores
	public User(String email, String password, String nombre,String nickname,String rol) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.nickname=nickname;
		this.rol=rol;
		listaalquiler=new HashSet<>();
	}
	public User(Integer id) {
		super();
		this.id = id;
	}
	//Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNickname() {
		return nickname;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Set<Alquiler> getListaalquiler() {
		return listaalquiler;
	}
	public void addAlquiler(Alquiler alquiler) {
		this.listaalquiler.add(alquiler);
	}
	public void setListaalquiler(Set<Alquiler> listaalquiler) {
		this.listaalquiler = listaalquiler;
	}
//ToString
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nombre=" + nombre + ", nickname="
				+ nickname + "+ y su rol es: "+rol+"]";
	}

	
}
