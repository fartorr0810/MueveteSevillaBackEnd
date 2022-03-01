package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmailRepetidoException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import java.util.Objects;
/**
 * Servicio del usuario 
 * @author estudiante
 *
 */
@Primary
@Service("servicioUsuario")
public class UsuarioServiceDB {
	//Inyectamos repositorio usuario
	@Autowired
	private UserRepo repositorioUser;
	/**
	 * Anadir usuario a la base de datos
	 * @param u usuario
	 * @return devuelve el usuario anadido en la base de datos.
	 */
	public User addUsuario(User u) {
		return repositorioUser.save(u);
	}
	/**
	 * Editamos el usuario en la base de datos.
	 * @param u usuario que vamos a recibir
	 * @return guardamos en la base datos el usuario y devuelve un usuario
	 */
	public User editUsuario(User u) {
		User aux=findById(u.getId());
		return repositorioUser.save(aux);
	}
	/**
	 * Busca por id un usuario
	 * @param id del usuario
	 * @return devuelve el usuario si existe, si no, devuelve null
	 */
	public User findById(Integer id) {
		return repositorioUser.findById(id).orElse(null);
	}
	/**
	 * Busca un usuario por email
	 * @param email del usuario que se va a buscar 
	 * @return devuelve un usuario que tenga ese mail, si lo encuentra, si no, null porque
	 * es de clase Optional
	 */
	public Optional<User> findByEmail(String email){
		return repositorioUser.findByEmail(email);
	}		
	}
