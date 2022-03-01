package com.example.demo.model;
/**
 * DTO con email y password
 * @author fartorr0810
 *
 */
public class LoginCredentials {
	//Atributos
    private String email;
    private String password;
    
   //Constructores
	public LoginCredentials() {
		super();
	}
	public LoginCredentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	//Getters y Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//ToString
	@Override
	public String toString() {
		return "LoginCredentials [email=" + email + ", password=" + password + "]";
	}
    
}