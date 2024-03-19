package com.lucatic.grupo2.app.eventmanager.exceptions;

/**
 * Clase personalizada de manejo de excepciones relacionados
 *
 * @author BlueDevTeams
 * @version v1.0.0
 * @since 19-03-2024
 */
public class EventManagerException extends Exception {

	/**
	 * Genera un serial para la excepcion personalizada
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe un mensaje del fallo
	 * 
	 * @param message descriptivo con el error
	 */
	public EventManagerException(String message) {
		super(message);
	}

	/**
	 * Constructor que recibe un mensaje y la causa lanzable del fallo
	 * 
	 * @param message descriptivo con el error
	 * @param cause   Detalles de motivos de la causa throwable.
	 */
	public EventManagerException(String message, Throwable cause) {
		super(message, cause);
	}
}
