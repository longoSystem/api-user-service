package com.longo.api.user;

/**
 * Inicializacao do API.
 * 
 * @author longo.juliano
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		log.info("Inicialização da API User Services.");
		SpringApplication.run(UserApplication.class, args);
	}
}
