package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comentario;
/**
 * Repositorio de comentarios
 * @author estudiante
 *
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Integer>{

}
