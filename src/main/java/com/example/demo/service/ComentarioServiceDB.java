package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comentario;
import com.example.demo.repository.ComentarioRepository;
/**
 * Servicio de comentarios.
 * @author estudiante
 *
 */
@Service("ComentarioService")
public class ComentarioServiceDB {
	//Inyeccion de repository
	@Autowired
	private ComentarioRepository repositorioComentario;
	
	/**
	 * Anade un comentario a la base de datos
	 * @param c comentario
	 * @return devuelve el objeto introducido a la base de datos
	 */
	public Comentario addComentario(Comentario c) {
		return repositorioComentario.save(c);
	}
	/**
	 * Elimina comentario pasandole el comentario
	 * @param c comentario
	 */
	public void deleteComentario(Comentario c) {
		repositorioComentario.delete(c);
	}
	/**
	 * Eliminar comentario por id.
	 * @param idcomentario que se va eliminar si existe.
	 */
	public void deleteComentarioById(Integer idcomentario) {
		repositorioComentario.deleteById(idcomentario);
	}
	
}
