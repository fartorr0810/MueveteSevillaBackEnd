package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/auth/register")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("GET", "POST", "PUT", "DELETE","Content-Type","X-Requested-With",
						"accept"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				
				registry.addMapping("/auth/login")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("GET", "POST", "PUT", "DELETE","Content-Type","X-Requested-With",
						"accept"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				
				registry.addMapping("/user/**")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("GET", "POST", "PUT", "DELETE","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/comentario")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("POST","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/patinete")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("GET", "POST", "PUT", "DELETE","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/alquiler/**")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("GET", "POST", "PUT", "DELETE","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/calcular-alquiler")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("POST","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/subida")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("POST","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
				registry.addMapping("/comprobar-email")
				.allowedOrigins("http://localhost:4200")
				.allowedHeaders("POST","Content-Type","X-Requested-With",
						"accept","Authorization"
						,"Origin","Access-Control-Request-Method","Access-Control-Request-Headers")
				.exposedHeaders("Access-Control-Allow-Origin","Access-Control-Allow-Credentials");
			}
		};
	}


}
