package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
/**
 * Repositorio de Usuarios
 * @author fartorr0810
 *
 */
public interface UserRepo extends JpaRepository<User, Integer> {
	/**
	 * Devuelve un usuario recibiendo el email , buscandolo en la base de datos
	 * si lo encuentra, devuelve el usuario, si no, devuelve null
	 * @param email que buscara en la base de datos
	 * @return devuelve el usuario o null segun si existe o no.
	 */
	public Optional<User> findByEmail(String email);
}
