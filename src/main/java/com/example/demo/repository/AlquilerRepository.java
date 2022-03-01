package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Alquiler;
/**
 * Repositorio de alquileres
 * @author estudiante
 *
 */
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
	/**
	 * Consulta personalizada que devuelve una lista de alquileres de un usuario 
	 * @param id de usuario
	 * @return devuelve una lista con los alquileres.
	 */
	@Query(value="SELECT * FROM alquiler.alquiler ta WHERE ta.user_id = :id",nativeQuery=true)
	List<Alquiler> findAlquilerUsuario(@Param("id") Integer id);
}
