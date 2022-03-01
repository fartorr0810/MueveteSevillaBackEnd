package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Patinete;
/**
 * Repositorio de servicios.
 * @author fartorr0810
 *
 */
public interface PatineteRepository extends JpaRepository<Patinete, Integer>{
	/**
	 * Consulta personalizada que devuelve una lista con los patinetes que sean disponibles
	 * @return devuelve una lista de patinetes.
	 */
	@Query("select p from Patinete p where p.disponible = true")
	List<Patinete> findPatinetesDisponibles();
}
