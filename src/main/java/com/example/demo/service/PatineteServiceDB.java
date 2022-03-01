package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patinete;
import com.example.demo.repository.PatineteRepository;
/**
 * Servicio Patinete con los metodos que le pertenecen
 * @author fartorr0810
 *
 */
@Service("PatineteServiceDB")
public class PatineteServiceDB implements PatineteService{
	//Inyeccion del repositorio.
	@Autowired 
	private PatineteRepository repositorioPatinete;
	@Override
	public Patinete addPatinete(Patinete p) {
		return repositorioPatinete.save(p);
	}

	@Override
	public Patinete findById(Integer id) {
		return repositorioPatinete.findById(id).orElse(null);
	}

	@Override
	public List<Patinete> findAll() {
		return repositorioPatinete.findAll();
	}
	/**
	 * Metodo para editar patinete, recibe el patinete y lo sobreescribe
	 * @param p patinete
	 * @return devuelve el patinete con los datos editados
	 */
	public Patinete edit(Patinete p) {
		return repositorioPatinete.save(p);
	}
	/**
	 * Metodo para buscar todos los patinetes disponibles
	 * @return devuelve la lista del patinetes
	 */
	public List<Patinete>findPatinetesDisponibles(){
		return repositorioPatinete.findPatinetesDisponibles();
	}
}
