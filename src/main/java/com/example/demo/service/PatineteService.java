package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comentario;
import com.example.demo.model.Patinete;
/**
 * Interfaz para servicios de Patinete
 * @author fartorr0810
 *
 */
public interface PatineteService {
	/**
	 * Recibe un patinete 
	 * @param p patinete
	 * @return devuelve el patinete anadido
	 */
	public Patinete addPatinete(Patinete p);
	/**
	 * Metedo para buscar un patinete por id
	 * @param id del patinete
	 * @return devuelve el patinete en cuestion
	 */
	public Patinete findById(Integer id);
	/**
	 * Metodo que devuelve todos los patinetes existentes.
	 * @return
	 */
	public List<Patinete> findAll();
}
