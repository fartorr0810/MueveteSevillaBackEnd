package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@SpringBootApplication
public class ApiPropia {
    @Autowired 
    private PasswordEncoder passwordEncoder;
	@Autowired 
	private UserRepo repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiPropia.class, args);


	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			List<User> lista=repositorio.findAll();
			Iterator<User> sig = lista.iterator();
			while (sig.hasNext()) {
				User user = sig.next();
				String encodedPass = passwordEncoder.encode(user.getPassword());
				user.setPassword(encodedPass);
				this.repositorio.save(user);
			}
			
		};
	}

}
