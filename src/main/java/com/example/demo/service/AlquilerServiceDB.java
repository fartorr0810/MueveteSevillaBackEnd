package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ErrorAlquilerException;
import com.example.demo.model.Alquiler;
import com.example.demo.model.AlquilerDTO;
import com.example.demo.model.Descuento;
import com.example.demo.model.Patinete;
import com.example.demo.model.User;
import com.example.demo.repository.AlquilerRepository;
/**
 * Clase AlquilerServiceDB con los metodos del servicio.
 * @author fartorr0810
 *
 */
@Service("ServicioAlquiler")
public class AlquilerServiceDB {
	@Autowired
	private AlquilerRepository repositorioalquiler;
	@Autowired
	private UsuarioServiceDB serviciousuario;
	@Autowired
	private PatineteServiceDB serviciopatinete;
	@Autowired
	private DescuentoServiceDB serviciodescuento;
//	@Autowired 
//	private Descuento
	
	/**
	 * Metodo para anadir alquiler, guardamos el usuario del alquiler lo buscamos,
	 * asignamos la hora de recogida,pero para ello convertimos las horas del alquiler a long,
	 * El patinete se es buscado, se asigna el precio del alquiler, si el patinete esta disponible
	 * se cambia su estado a false , se persiste los cambios del patinete, se anade el alquiler
	 * al usuario, se persiste el alquiler y se edita el usuario por final. Tras estas acciones
	 * construimos el objeto que nos v
	 * @param alquiler
	 * @return devuelve el objeto con la respuesta de lo que se ha añadido
	 * @throws Exception si hay algun problema , devuelve una excepcio
	 */
	public AlquilerDTO addAlquiler(Alquiler alquiler) throws Exception {
		User user=this.serviciousuario.findById(alquiler.getUser().getId());
		Long l = Long.valueOf(alquiler.getHorasalquiler());
		alquiler.setHorarecogida(alquiler.getHoraentrega().plusHours(l));
		Patinete p=this.serviciopatinete.findById(alquiler.getPatinete().getIdpatinete());
		alquiler.setPreciototal(alquiler.getHorasalquiler()*p.getPrecioHora());
		if (Boolean.TRUE.equals(p.getDisponible())) {
			p.setDisponible(false);
			this.serviciopatinete.edit(p);
			Descuento des=this.serviciodescuento.findByCodigo(alquiler.getCodigo());
			if (des!=null && Objects.equals(alquiler.getCodigo(), des.getCodigo())) {
				if (des.getUsos()>0) {					
					alquiler.setPreciototal(alquiler.getPreciototal()-des.getPrecioalDescontado());
					des.setUsos(des.getUsos()-1);
					this.serviciodescuento.edit(des);
				}
				else {
					alquiler.setCodigo("CODIGO INCORRECTO");
				}
			}
			user.addAlquiler(alquiler);
			this.repositorioalquiler.save(alquiler);
			this.serviciousuario.editUsuario(user);
			AlquilerDTO result=new AlquilerDTO();
			result.setHoraentrega(alquiler.getHoraentrega());
			result.setHorarecogida(alquiler.getHorarecogida());
			result.setHorasalquiler(alquiler.getHorasalquiler());
			result.setPreciototal(alquiler.getPreciototal());
			result.setModelo(p.getModelo());
			result.setEntregado(alquiler.getEntregado());
			result.setIdalquiler(alquiler.getIdalquiler());
			result.setCodigoDescuento(alquiler.getCodigo());
			return result;
		}else {
			throw new ErrorAlquilerException();
		}
	}
	/**
	 * Metodo para calcular el precio del alquiler y nos devuelve la respuesta con el precio,
	 * y la hora de devolucion
	 * @param alquiler recibe un objeto alquiler 
	 * @return devuelve la respuesta
	 * @throws Exception si hay algun tipo de problema, devuelve una excepcion
	 */
	public AlquilerDTO calcularPrecio(Alquiler alquiler) throws Exception {
		Long l = Long.valueOf(alquiler.getHorasalquiler());
		alquiler.setHorarecogida(alquiler.getHoraentrega().plusHours(l));
		Patinete p=this.serviciopatinete.findById(alquiler.getPatinete().getIdpatinete());
		alquiler.setPreciototal(p.getPrecioHora()*alquiler.getHorasalquiler());
		Descuento des=this.serviciodescuento.findByCodigo(alquiler.getCodigo());
		AlquilerDTO result=new AlquilerDTO();
		result.setPreciototal(p.getPrecioHora()*alquiler.getHorasalquiler());
		if (des!=null && Objects.equals(alquiler.getCodigo(), des.getCodigo())) {
			if (des.getUsos()>0) {					
				alquiler.setPreciototal(alquiler.getPreciototal()-des.getPrecioalDescontado());
				des.setUsos(des.getUsos()-1);
			}
			else {
				alquiler.setCodigo("CODIGO INCORRECTO");
			}
		}
		result.setPreciototal(alquiler.getPreciototal());
		result.setHoraentrega(alquiler.getHoraentrega());
		result.setHorarecogida(alquiler.getHorarecogida());
		result.setHorasalquiler(alquiler.getHorasalquiler());
		result.setCodigoDescuento(alquiler.getCodigo());
		return result;
	}
	/**
	 * Entrega patinete y lo vuelve a marcar como disponible
	 * @param id del alquiler.
	 */
	public void entregarPatinete(Integer id) {
		Alquiler alq=repositorioalquiler.findById(id).orElse(null);
		this.serviciousuario.findById(alq.getUser().getId());
		alq.getPatinete().setDisponible(true);
		this.serviciopatinete.edit(alq.getPatinete());
		alq.setEntregado(true);
		this.editAlquiler(alq);
	}
	/**
	 * Recorre los alquileres del usuario en cuestion y lo convierte a una respuesta que 
	 * el usuario deberia ver.
	 * @param listaalquiler lista de alquileres.
	 * @return devuelve la lista de alquileres.
	 */
	public List<AlquilerDTO> conversorAlquilerAdto(List<Alquiler> listaalquiler){
		List<AlquilerDTO> lista=new ArrayList<>();
		Iterator<Alquiler> sig = listaalquiler.iterator();
		while (sig.hasNext()) {
			Alquiler a = sig.next();
			Patinete p=this.serviciopatinete.findById(a.getPatinete().getIdpatinete());
			AlquilerDTO result=new AlquilerDTO();
			result.setHoraentrega(a.getHoraentrega());
			result.setHorarecogida(a.getHorarecogida());
			result.setHorasalquiler(a.getHorasalquiler());
			Double precio=(double) (Math.round(a.getPreciototal()*100.0)/100.0);
			result.setPreciototal(precio);
			result.setEntregado(a.getEntregado());
			result.setModelo(p.getModelo());
			result.setIdalquiler(a.getIdalquiler());
			lista.add(result);
			}
		return lista;
	}
	/**
	 * Busca por id de alquiler en la base de datos
	 * @param id id del alquiler que se busca
	 * @return devuelve el alquiler en cuestion y si no , devuelve null
	 */
	public Alquiler findById(Integer id) {
		return repositorioalquiler.findById(id).orElse(null);
	}
	/**
	 * Busca por id de usuario en la base de datos todos los alquileres que le pertenecen
	 * @param id del usuario
	 * @return devuelve una lista con todos sus alquileres.
	 */
	public List<Alquiler> findByUser(Integer id){
		return repositorioalquiler.findAlquilerUsuario(id);
	}
	public Alquiler editAlquiler(Alquiler alq) {
		return repositorioalquiler.save(alq);
	}
}
