package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiError;
import com.example.demo.exception.EmailRepetidoException;
import com.example.demo.exception.EmailVacioException;
import com.example.demo.exception.LoginErrorException;
import com.example.demo.exception.PasswordVaciaException;
import com.example.demo.model.LoginCredentials;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JWTUtil;
import com.example.demo.service.UsuarioServiceDB;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class AuthController {

    @Autowired 
    private UserRepo userRepo;
    @Autowired 
    private JWTUtil jwtUtil;
    @Autowired 
    private AuthenticationManager authManager;
    @Autowired 
    private PasswordEncoder passwordEncoder;
    @Autowired 
    private UsuarioServiceDB servicioUsuario;
    
    /**
     * Metodo para registrar un usuario , recibe un usuario, tras ello, encodifica la contrasena
     * en el try probamos meter el usuario, si se repite el email , lazara una excepcion de email repetido
     * si esta bien, se registra y nos devolvera un token
     * @param user
     * @return
     */
    @PostMapping("auth/register")
    public Map<String, Object> registerHandler(@RequestBody User user){
        if (user.getEmail()==null) {
        	throw new EmailVacioException();
        }
        //Aqui no pasa si lanza la excepcion arriba.
        if (user.getEmail().isEmpty()) {
        	throw new EmailVacioException();
        }
        if (user.getPassword()==null) {
        	throw new PasswordVaciaException();
        }
        if (user.getPassword().isEmpty()) {
        	throw new PasswordVaciaException();	
        }
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setRol("User");
        user.setPassword(encodedPass);
        try {
        	user = this.servicioUsuario.addUsuario(user);
        	String token = jwtUtil.generateToken(user.getEmail());
        	Map<String, Object> mapa =new HashMap<>(); 
            mapa.put("jwt_token", token);
            User usuario=userRepo.findByEmail(user.getEmail()).orElse(null);
            if (usuario!=null) {
            	mapa.put("idusuario", usuario.getId());            	
            	mapa.put("rol", usuario.getRol());
            }
        	return mapa;       	
        }catch (IllegalArgumentException ex) {
        	//TODO, Invalid register
        	throw new EmailRepetidoException(user.getEmail());
        }

    }
    /**
     * Metodo para logearnos, recibe un usuario y un password, tras ello nos creara un token y nos lo devolvera
     * y si hay un error, nos devuelve la excepcion. 
     * @param body recibe los usuarios
     * @return nos devuelve el token y si no , la excepcion
     */
    @PostMapping("auth/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        if (body.getEmail()==null) {
        	throw new EmailVacioException();
        }
        //Aqui no pasa si lanza la excepcion arriba.
        if (body.getEmail().isEmpty()) {
        	throw new EmailVacioException();
        }
        if (body.getPassword()==null) {
        	throw new PasswordVaciaException();
        }
        if (body.getPassword().isEmpty()) {
        	throw new PasswordVaciaException();	
        }
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());
            authManager.authenticate(authInputToken);
            String token = jwtUtil.generateToken(body.getEmail());
            Map<String, Object> mapa =new HashMap<>(); 
            mapa.put("jwt_token", token);
            User user=userRepo.findByEmail(body.getEmail()).orElse(null);
            if (user!=null) {
            	mapa.put("idusuario", user.getId());            	
            	mapa.put("rol", user.getRol());
            }
            return mapa;
        }catch (AuthenticationException authExc){
            throw new LoginErrorException();
        }
    }
    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<ApiError> handlerLogin(LoginErrorException ex){
    	ApiError apierror=new ApiError();
    	apierror.setEstado(HttpStatus.NOT_FOUND);
    	apierror.setMensaje(ex.getMessage());
    	apierror.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apierror);
    }
    /**
     * Handler que construye el error en caso de que el email este repetido 
     * @param ex excepcion
     * @return devuelve el 404 y el objeto de apierror con los errores
     */
    @ExceptionHandler(EmailRepetidoException.class)
    public ResponseEntity<ApiError> handleNoEmail(EmailRepetidoException ex){
    	ApiError apierror=new ApiError();
    	apierror.setEstado(HttpStatus.NOT_FOUND);
    	apierror.setMensaje(ex.getMessage());
    	apierror.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apierror);
    }
    /**
     * Error en caso de que el email este vacio
     * @param ex excepcion
     * @return devuelve el apierror con los datos de la excepcion
     */
    @ExceptionHandler(EmailVacioException.class)
    public ResponseEntity<ApiError> emailVacio(EmailVacioException ex){
    	ApiError apierror=new ApiError();
    	apierror.setEstado(HttpStatus.BAD_REQUEST);
    	apierror.setMensaje(ex.getMessage());
    	apierror.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apierror);
    }
    /**
     * Error en caso de que el password este vacio
     * @param ex excepcion
     * @return devuelve el apierror con los datos de la excepcion
     */
    @ExceptionHandler(PasswordVaciaException.class)
    public ResponseEntity<ApiError> passwordVacio(PasswordVaciaException ex){
    	ApiError apierror=new ApiError();
    	apierror.setEstado(HttpStatus.BAD_REQUEST);
    	apierror.setMensaje(ex.getMessage());
    	apierror.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apierror);
    }
    /**
     * Handler que nos construye el error en caso que haya problemas.
     * @param ex excepcion 
     * @return devuelve badquest y el objeto de la apierror.
     */
    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ApiError> handleJsonMappingException(JsonMappingException ex){
    	ApiError apierror=new ApiError();
    	apierror.setEstado(HttpStatus.BAD_REQUEST);
    	apierror.setMensaje(ex.getMessage());
    	apierror.setFecha(LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apierror);
    }
}
