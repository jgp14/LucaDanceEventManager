package com.lucatic.grupo2.app.eventmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Clase principal
 *
 * @author BlueDevTeam
 * @version 1.0.0
 * @since 19-03-2024
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LucaDanceEventManagerApplication {

	/**
	 * Punto de entrada al programa principal
	 * 
	 * @param args Argumentos por línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(LucaDanceEventManagerApplication.class, args);
	}

}
